package com.example.deliveryexample.infrastructure.secundary.db.mapper;

import com.example.deliveryexample.core.domain.Restaurant;
import com.example.deliveryexample.infrastructure.secundary.db.entity.RestaurantEntity;

public interface RestaurantMapper {

    Restaurant toDomain(RestaurantEntity restaurantEntity);


}
