package com.example.deliveryexample.infrastructure.secundary.persitence.dao;

import com.example.deliveryexample.infrastructure.secundary.persitence.entity.RestaurantEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantData extends MongoRepository<RestaurantEntity, String> {

    RestaurantEntity findFirstByName(String name);

}
