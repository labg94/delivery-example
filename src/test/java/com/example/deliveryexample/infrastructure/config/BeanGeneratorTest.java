package com.example.deliveryexample.infrastructure.config;

import com.example.deliveryexample.core.NewOrderToDeliver;
import com.example.deliveryexample.core.secundary.DelivererRepository;
import com.example.deliveryexample.core.secundary.RestaurantRepository;
import com.example.deliveryexample.core.services.OrderGenerated;
import com.example.deliveryexample.utils.mother.DelivererMother;
import com.example.deliveryexample.utils.mother.RestaurantMother;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeanGeneratorTest {

    private final BeanGenerator beanGenerator= new BeanGenerator();


    @Test
    void newOrderToDeliver() {

        DelivererRepository delivererRepository = DelivererMother::model;
        RestaurantRepository restaurantRepository = name -> RestaurantMother.model();
        NewOrderToDeliver newOrderToDeliver = beanGenerator.newOrderToDeliver(delivererRepository, restaurantRepository);

        assertNotNull(newOrderToDeliver);
        assertTrue(newOrderToDeliver instanceof OrderGenerated);
    }
}