package com.example.deliveryexample.core.domain;

import com.example.deliveryexample.core.errors.PlateNotFound;

import java.util.List;

public record Restaurant(String name, String rut, List<Food> plates) {


    public Food cookPlate(String plateName) {
        return plates.stream()
                     .filter(food -> food.name().equals(plateName))
                     .findFirst()
                     .orElseThrow(() -> new PlateNotFound(plateName, this.name));
    }


}
