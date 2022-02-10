package com.example.deliveryexample.infrastructure.secundary.persitence.mapper;

import com.example.deliveryexample.core.domain.Restaurant;
import com.example.deliveryexample.infrastructure.secundary.persitence.entity.RestaurantEntity;

public interface RestaurantMapper {

    Restaurant toDomain(RestaurantEntity restaurantEntity);


}
