package com.example.deliveryexample.core.secundary;

import com.example.deliveryexample.core.domain.Restaurant;

public interface RestaurantRepository {

    Restaurant findRestaurantByName(String name);

}
