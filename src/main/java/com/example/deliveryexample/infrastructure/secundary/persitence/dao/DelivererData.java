package com.example.deliveryexample.infrastructure.secundary.persitence.dao;

import com.example.deliveryexample.infrastructure.secundary.persitence.entity.DelivererEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DelivererData extends MongoRepository<DelivererEntity, String> {

    DelivererEntity findFirstByAvailableTrue();

}
