package com.example.deliveryexample.core.services;

import com.example.deliveryexample.core.domain.Deliverer;
import com.example.deliveryexample.core.domain.Order;
import com.example.deliveryexample.core.errors.PlateNotFound;
import com.example.deliveryexample.core.errors.RestaurantNotfound;
import com.example.deliveryexample.core.errors.UnavailableDeliverers;
import com.example.deliveryexample.core.secundary.DelivererRepository;
import com.example.deliveryexample.core.secundary.RestaurantRepository;
import com.example.deliveryexample.utils.mother.DeliverMother;
import com.example.deliveryexample.utils.mother.FoodMother;
import com.example.deliveryexample.utils.mother.RestaurantMother;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderGeneratedTest {


    @Test
    @DisplayName("Given an orden should deliver the food")
    void GoodDeliver() {

        Order order = new Order(FoodMother.pasta().name(), RestaurantMother.createRestaurant().name());

        OrderGenerated orderGenerated = validOrderGenerated();


        Deliverer deliverer = orderGenerated.sendDelivery(order);


        assertEquals(FoodMother.pasta(), deliverer.foodToDeliver());
        assertEquals(DeliverMother.deliveryTester().name(), deliverer.name());
        assertEquals(DeliverMother.deliveryTester().rut(), deliverer.rut());
    }


    @Test
    @DisplayName("Given an orden with an invalid food name should throw an exception")
    void foodNotFound() {

        String invalidPlateName = "Guasacaca";
        Order order = new Order(invalidPlateName, RestaurantMother.createRestaurant().name());

        OrderGenerated orderGenerated = validOrderGenerated();

        PlateNotFound exception = assertThrows(PlateNotFound.class,
                () -> orderGenerated.sendDelivery(order));


        String expectedErrorMessage = String.format("The plate %s cannot be cooked in the restaurant selected %s",
                invalidPlateName,
                RestaurantMother.createRestaurant().name());


        assertEquals(expectedErrorMessage, exception.getMessage());

    }

    private OrderGenerated validOrderGenerated() {
        DelivererRepository deliveryRepository = DeliverMother::deliveryTester;
        RestaurantRepository restaurantRepository = name -> RestaurantMother.createRestaurant();
        return new OrderGenerated(deliveryRepository, restaurantRepository);
    }

    @Test
    @DisplayName("Given an orden with an invalid restaurant should throw an exception")
    void restaurantNotFound() {

        String restaurantName = "Le invalid";
        Order order = new Order(FoodMother.pasta().name(), restaurantName);

        DelivererRepository deliveryRepository = DeliverMother::deliveryTester;
        RestaurantRepository restaurantRepository = name -> {
            throw new RestaurantNotfound(restaurantName);
        };

        OrderGenerated orderGenerated = new OrderGenerated(deliveryRepository, restaurantRepository);


        RestaurantNotfound restaurantNotfound = assertThrows(RestaurantNotfound.class,
                () -> orderGenerated.sendDelivery(order));

        String expectedErrorMessage = String.format("Restaurant with name: %s does not exist", restaurantName);


        assertEquals(expectedErrorMessage, restaurantNotfound.getMessage());
    }


    @Test
    void notDelivererFound() {

        String restaurantName = "Le invalid";
        Order order = new Order(FoodMother.pasta().name(), restaurantName);

        DelivererRepository deliveryRepository = () -> {
            throw new UnavailableDeliverers();
        };
        RestaurantRepository restaurantRepository = name -> RestaurantMother.createRestaurant();

        OrderGenerated orderGenerated = new OrderGenerated(deliveryRepository, restaurantRepository);


        UnavailableDeliverers exception = assertThrows(UnavailableDeliverers.class,
                () -> orderGenerated.sendDelivery(order));


        assertEquals("There are not available deliverers", exception.getMessage());
    }


}