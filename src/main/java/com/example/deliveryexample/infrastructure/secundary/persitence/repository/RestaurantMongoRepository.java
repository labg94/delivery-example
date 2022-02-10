package com.example.deliveryexample.infrastructure.secundary.persitence.repository;

import com.example.deliveryexample.core.domain.Restaurant;
import com.example.deliveryexample.core.errors.RestaurantNotfound;
import com.example.deliveryexample.core.secundary.RestaurantRepository;
import com.example.deliveryexample.infrastructure.secundary.persitence.dao.RestaurantData;
import com.example.deliveryexample.infrastructure.secundary.persitence.entity.RestaurantEntity;
import com.example.deliveryexample.infrastructure.secundary.persitence.mapper.RestaurantMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantMongoRepository implements RestaurantRepository {
    private final RestaurantData restaurantData;

    private final RestaurantMapper restaurantMapper;

    public RestaurantMongoRepository(RestaurantData restaurantData, RestaurantMapper restaurantMapper) {
        this.restaurantData = restaurantData;
        this.restaurantMapper = restaurantMapper;
    }


    @Override
    public Restaurant findRestaurantByName(String name) {
        RestaurantEntity entity = restaurantData.findFirstByName(name).orElseThrow(() -> new RestaurantNotfound(name));

        return restaurantMapper.toDomain(entity);
    }
}