package com.example.deliveryexample.utils.mother;

import com.example.deliveryexample.core.NewOrderToDeliver;
import com.example.deliveryexample.core.errors.RestaurantNotfound;
import com.example.deliveryexample.core.errors.UnavailableDeliverers;
import com.example.deliveryexample.core.secundary.DelivererRepository;
import com.example.deliveryexample.core.secundary.RestaurantRepository;
import com.example.deliveryexample.core.services.OrderGenerated;

public class NewOrderToDeliverMother {
    public static NewOrderToDeliver validOrderGenerated() {
        DelivererRepository deliveryRepository = DelivererMother::model;
        RestaurantRepository restaurantRepository = name -> RestaurantMother.model();
        return new OrderGenerated(deliveryRepository, restaurantRepository);
    }

    public static NewOrderToDeliver restaurantException(String restaurantName) {
        DelivererRepository deliveryRepository = DelivererMother::model;
        RestaurantRepository restaurantRepository = name -> {
            throw new RestaurantNotfound(restaurantName);
        };

        return new OrderGenerated(deliveryRepository, restaurantRepository);
    }

    public static NewOrderToDeliver delivererException() {
        DelivererRepository deliveryRepository = () -> {
            throw new UnavailableDeliverers();
        };
        RestaurantRepository restaurantRepository = name -> RestaurantMother.model();

        return new OrderGenerated(deliveryRepository, restaurantRepository);
    }
}
