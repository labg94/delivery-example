package com.example.deliveryexample.core.errors;

public class RestaurantNotfound extends RuntimeException {

    public RestaurantNotfound(String restaurantName) {
        super(String.format("Restaurant with name: %s does not exist", restaurantName));
    }
}
