package com.example.deliveryexample.infrastructure.primary.rest.mapper;

import com.example.deliveryexample.core.domain.Order;
import com.example.deliveryexample.infrastructure.primary.rest.request.OrderRequest;

public interface OrderRequestMapper {

    Order toModel(OrderRequest request);

}
