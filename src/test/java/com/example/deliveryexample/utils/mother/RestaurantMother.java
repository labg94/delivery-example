package com.example.deliveryexample.utils.mother;

import com.example.deliveryexample.core.domain.Restaurant;

import java.util.List;

public class RestaurantMother {
    public static Restaurant createRestaurant() {
        return new Restaurant("Le Test Restaurant",
                "1223",
                List.of(FoodMother.beans(), FoodMother.pasta()));
    }
}
