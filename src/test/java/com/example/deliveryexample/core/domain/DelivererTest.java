package com.example.deliveryexample.core.domain;

import com.example.deliveryexample.utils.mother.DeliverMother;
import com.example.deliveryexample.utils.mother.FoodMother;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelivererTest {


    @Test
    void addFood() {

        Deliverer deliverer = DeliverMother.deliveryTester();
        Food foodBefore = deliverer.foodToDeliver();

        deliverer.receiveFood(FoodMother.pasta());

        assertNull(foodBefore);
        assertEquals(FoodMother.pasta(),deliverer.foodToDeliver());
    }

}