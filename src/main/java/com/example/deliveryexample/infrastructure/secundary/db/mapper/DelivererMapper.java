package com.example.deliveryexample.infrastructure.secundary.db.mapper;

import com.example.deliveryexample.core.domain.Deliverer;
import com.example.deliveryexample.infrastructure.secundary.db.entity.DelivererEntity;

public interface DelivererMapper {

    Deliverer toModel(DelivererEntity delivererEntity);

}
