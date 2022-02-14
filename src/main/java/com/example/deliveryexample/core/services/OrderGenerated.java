package com.example.deliveryexample.core.services;

import com.example.deliveryexample.core.NewOrderToDeliver;
import com.example.deliveryexample.core.domain.Deliverer;
import com.example.deliveryexample.core.domain.Food;
import com.example.deliveryexample.core.domain.Order;
import com.example.deliveryexample.core.domain.Restaurant;
import com.example.deliveryexample.core.secundary.DelivererRepository;
import com.example.deliveryexample.core.secundary.RestaurantRepository;

public record OrderGenerated(DelivererRepository delivererRepository,
                             RestaurantRepository restaurantRepository) implements NewOrderToDeliver {

    @Override
    public Deliverer sendDelivery(Order order) {

        Deliverer deliverer = delivererRepository.findAvailableDelivery();
        Restaurant restaurant = restaurantRepository.findRestaurantByName(order.restaurantName());

        Food food = restaurant.cookPlate(order.foodName());

        return deliverer.receiveFood(food);
    }
}
