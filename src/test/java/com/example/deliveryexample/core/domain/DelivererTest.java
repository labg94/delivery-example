package com.example.deliveryexample.core.domain;

import com.example.deliveryexample.utils.mother.DelivererMother;
import com.example.deliveryexample.utils.mother.FoodMother;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelivererTest {


    @Test
    void addFood() {

        Deliverer deliverer = DelivererMother.model();

        Deliverer updatedDeliverer = deliverer.receiveFood(FoodMother.pasta());

        assertNull(deliverer.foodToDeliver());
        assertEquals(FoodMother.pasta(), updatedDeliverer.foodToDeliver());
    }

}