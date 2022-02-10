package com.example.deliveryexample.utils.mother;

import com.example.deliveryexample.core.domain.Food;
import com.example.deliveryexample.infrastructure.primary.rest.response.Dish;

public class FoodMother {


    private static final String PASTA = "Pasta";
    private static final double PASTA_CALORIES = 250.4;
    private static final boolean IS_PASTA_VEGAN = false;

    public static Food pasta() {
        return new Food(PASTA, PASTA_CALORIES, IS_PASTA_VEGAN);
    }

    public static Dish pastaAsDish() {
        return new Dish(PASTA, PASTA_CALORIES, IS_PASTA_VEGAN);
    }


    public static Food beans() {
        return new Food("Black Beans", 200, true);
    }

}
