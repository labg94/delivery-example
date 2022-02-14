package com.example.deliveryexample.infrastructure.secundary.db.repository;

import com.example.deliveryexample.core.domain.Restaurant;
import com.example.deliveryexample.core.errors.RestaurantNotfound;
import com.example.deliveryexample.core.secundary.RestaurantRepository;
import com.example.deliveryexample.infrastructure.secundary.db.dao.RestaurantData;
import com.example.deliveryexample.infrastructure.secundary.db.entity.RestaurantEntity;
import com.example.deliveryexample.infrastructure.secundary.db.mapper.RestaurantMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RestaurantMongoRepository implements RestaurantRepository {
    private final RestaurantData restaurantData;

    private final RestaurantMapper restaurantMapper;


    @Override
    public Restaurant findRestaurantByName(String name) {
        return restaurantMapper.toDomain(findOrThrowException(name));
    }

    private RestaurantEntity findOrThrowException(String name) {
        return restaurantData.findFirstByName(name).orElseThrow(() -> new RestaurantNotfound(name));
    }
}
