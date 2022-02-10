package com.example.deliveryexample.infrastructure.primary.rest.mapper;

import com.example.deliveryexample.core.domain.Order;
import com.example.deliveryexample.infrastructure.primary.rest.request.OrderRequest;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapperImpl implements OrderRequestMapper {
    @Override
    public Order toModel(OrderRequest request) {
        return new Order(request.getFood(), request.getRestaurant());
    }
}
