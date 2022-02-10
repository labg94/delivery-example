package com.example.deliveryexample.infrastructure.secundary.persitence.dao;

import com.example.deliveryexample.infrastructure.secundary.persitence.entity.RestaurantEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RestaurantData extends MongoRepository<RestaurantEntity, String> {

    Optional<RestaurantEntity> findFirstByName(String name);

}
