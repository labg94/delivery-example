package com.example.deliveryexample.core.domain;

import com.example.deliveryexample.utils.mother.DelivererMother;
import com.example.deliveryexample.utils.mother.FoodMother;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelivererTest {


    @Test
    void addFood() {

        Deliverer deliverer = DelivererMother.model();
        Food foodBefore = deliverer.foodToDeliver();

        deliverer.receiveFood(FoodMother.pasta());

        assertNull(foodBefore);
        assertEquals(FoodMother.pasta(),deliverer.foodToDeliver());
    }

}