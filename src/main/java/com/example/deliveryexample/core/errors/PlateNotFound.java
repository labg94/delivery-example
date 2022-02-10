package com.example.deliveryexample.core.errors;

public class PlateNotFound extends RuntimeException {

    public PlateNotFound(String plateName, String restaurantName) {
        super(String.format("The plate %s cannot be cooked in the restaurant selected %s", plateName, restaurantName));
    }
}
