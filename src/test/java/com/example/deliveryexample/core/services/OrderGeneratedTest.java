package com.example.deliveryexample.core.services;

import com.example.deliveryexample.core.NewOrderToDeliver;
import com.example.deliveryexample.core.domain.Deliverer;
import com.example.deliveryexample.core.domain.Order;
import com.example.deliveryexample.core.errors.PlateNotFound;
import com.example.deliveryexample.core.errors.RestaurantNotfound;
import com.example.deliveryexample.core.errors.UnavailableDeliverers;
import com.example.deliveryexample.utils.mother.DelivererMother;
import com.example.deliveryexample.utils.mother.FoodMother;
import com.example.deliveryexample.utils.mother.NewOrderToDeliverMother;
import com.example.deliveryexample.utils.mother.RestaurantMother;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderGeneratedTest {


    @Test
    @DisplayName("Given an orden should deliver the food")
    void GoodDeliver() {

        Order order = new Order(FoodMother.pasta().name(), RestaurantMother.model().name());

        NewOrderToDeliver orderGenerated = NewOrderToDeliverMother.validOrderGenerated();

        Deliverer deliverer = orderGenerated.sendDelivery(order);


        assertEquals(FoodMother.pasta(), deliverer.foodToDeliver());
        assertEquals(DelivererMother.model().name(), deliverer.name());
        assertEquals(DelivererMother.model().rut(), deliverer.rut());
    }


    @Test
    @DisplayName("Given an orden with an invalid food name should throw an exception")
    void foodNotFound() {

        String invalidPlateName = "Guasacaca";
        Order order = new Order(invalidPlateName, RestaurantMother.model().name());

        NewOrderToDeliver orderGenerated = NewOrderToDeliverMother.validOrderGenerated();

        PlateNotFound exception = assertThrows(PlateNotFound.class,
                () -> orderGenerated.sendDelivery(order));


        String expectedErrorMessage = String.format("The plate %s cannot be cooked in the restaurant selected %s",
                invalidPlateName,
                RestaurantMother.model().name());


        assertEquals(expectedErrorMessage, exception.getMessage());

    }

    @Test
    @DisplayName("Given an orden with an invalid restaurant should throw an exception")
    void restaurantNotFound() {

        String restaurantName = "Le invalid";
        Order order = new Order(FoodMother.pasta().name(), restaurantName);

        NewOrderToDeliver orderGenerated = NewOrderToDeliverMother.restaurantException(restaurantName);


        RestaurantNotfound restaurantNotfound = assertThrows(RestaurantNotfound.class,
                () -> orderGenerated.sendDelivery(order));

        String expectedErrorMessage = String.format("Restaurant with name: %s does not exist", restaurantName);


        assertEquals(expectedErrorMessage, restaurantNotfound.getMessage());
    }


    @Test
    void notDelivererFound() {

        Order order = new Order(FoodMother.pasta().name(), RestaurantMother.model().name());

        NewOrderToDeliver orderGenerated = NewOrderToDeliverMother.delivererException();

        UnavailableDeliverers exception = assertThrows(UnavailableDeliverers.class,
                () -> orderGenerated.sendDelivery(order));


        assertEquals("There are not available deliverers", exception.getMessage());
    }


}