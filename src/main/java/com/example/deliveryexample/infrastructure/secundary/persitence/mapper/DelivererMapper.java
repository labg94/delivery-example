package com.example.deliveryexample.infrastructure.secundary.persitence.mapper;

import com.example.deliveryexample.core.domain.Deliverer;
import com.example.deliveryexample.infrastructure.secundary.persitence.entity.DelivererEntity;

public interface DelivererMapper {

    Deliverer toModel(DelivererEntity delivererEntity);

}
