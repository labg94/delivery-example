package com.example.deliveryexample.infrastructure.secundary.db.dao;

import com.example.deliveryexample.infrastructure.secundary.db.entity.DelivererEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DelivererData extends MongoRepository<DelivererEntity, String> {

    Optional<DelivererEntity> findFirstByAvailableTrue();

}
