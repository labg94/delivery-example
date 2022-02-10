package com.example.deliveryexample.infrastructure.secundary.db.dao;

import com.example.deliveryexample.infrastructure.secundary.db.entity.RestaurantEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RestaurantData extends MongoRepository<RestaurantEntity, String> {

    Optional<RestaurantEntity> findFirstByName(String name);

}
