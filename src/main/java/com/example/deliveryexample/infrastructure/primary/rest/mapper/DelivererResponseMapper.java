package com.example.deliveryexample.infrastructure.primary.rest.mapper;

import com.example.deliveryexample.core.domain.Deliverer;
import com.example.deliveryexample.infrastructure.primary.rest.response.DelivererResponse;

public interface DelivererResponseMapper {

    DelivererResponse toResponse(Deliverer deliverer);

}
