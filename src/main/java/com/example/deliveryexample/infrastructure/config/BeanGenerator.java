package com.example.deliveryexample.infrastructure.config;

import com.example.deliveryexample.core.NewOrderToDeliver;
import com.example.deliveryexample.core.secundary.DelivererRepository;
import com.example.deliveryexample.core.secundary.RestaurantRepository;
import com.example.deliveryexample.core.services.OrderGenerated;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanGenerator {


    @Bean
    public NewOrderToDeliver newOrderToDeliver(DelivererRepository deliverer, RestaurantRepository restaurant) {
        return new OrderGenerated(deliverer, restaurant);
    }


}
