package com.example.deliveryexample.infrastructure.secundary.db.repository;

import com.example.deliveryexample.core.domain.Deliverer;
import com.example.deliveryexample.core.errors.UnavailableDeliverers;
import com.example.deliveryexample.core.secundary.DelivererRepository;
import com.example.deliveryexample.infrastructure.secundary.db.dao.DelivererData;
import com.example.deliveryexample.infrastructure.secundary.db.entity.DelivererEntity;
import com.example.deliveryexample.infrastructure.secundary.db.mapper.DelivererMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DelivererMongoRepository implements DelivererRepository {

    private final DelivererMapper mapper;
    private final DelivererData data;

    @Override
    public Deliverer findAvailableDelivery() {
        DelivererEntity entity = data.findFirstByAvailableTrue().orElseThrow(UnavailableDeliverers::new);
        return mapper.toModel(entity);
    }
}
