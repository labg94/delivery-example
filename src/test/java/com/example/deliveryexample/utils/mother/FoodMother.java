package com.example.deliveryexample.utils.mother;

import com.example.deliveryexample.core.domain.Food;

public class FoodMother {


    public static Food pasta(){
        return new Food("Pasta",250.4,false);
    }

    public static Food beans(){
        return new Food("Black Beans", 200, true);
    }

}
