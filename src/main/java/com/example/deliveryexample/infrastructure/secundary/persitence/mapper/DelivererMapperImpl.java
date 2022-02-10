package com.example.deliveryexample.infrastructure.secundary.persitence.mapper;

import com.example.deliveryexample.core.domain.Deliverer;
import com.example.deliveryexample.infrastructure.secundary.persitence.entity.DelivererEntity;
import org.springframework.stereotype.Component;

@Component
public class DelivererMapperImpl implements DelivererMapper {
    @Override
    public Deliverer toModel(DelivererEntity delivererEntity) {
        return new Deliverer(delivererEntity.name(), delivererEntity.rut());
    }
}
