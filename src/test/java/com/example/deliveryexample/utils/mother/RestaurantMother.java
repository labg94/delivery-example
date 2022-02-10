package com.example.deliveryexample.utils.mother;

import com.example.deliveryexample.core.domain.Food;
import com.example.deliveryexample.core.domain.Restaurant;
import com.example.deliveryexample.infrastructure.secundary.persitence.entity.Plate;
import com.example.deliveryexample.infrastructure.secundary.persitence.entity.RestaurantEntity;

import java.util.List;

public class RestaurantMother {

    public static final String RESTAURANT_NAME = "Le Test Restaurant";
    private static final String RUT = "1223";
    private static final List<Food> FOODS = List.of(FoodMother.beans(), FoodMother.pasta());

    public static Restaurant model() {
        return new Restaurant(RESTAURANT_NAME, RUT, FOODS);
    }

    public static RestaurantEntity entity() {

        return new RestaurantEntity(null, RESTAURANT_NAME, RUT, getPlates());
    }

    private static List<Plate> getPlates() {
        return FOODS.stream()
                    .map(food -> new Plate(food.name(), food.calories(), food.isVegan()))
                    .toList();
    }
}
