package com.example.deliveryexample.infrastructure.primary.rest.controller;

import com.example.deliveryexample.core.NewOrderToDeliver;
import com.example.deliveryexample.core.domain.Deliverer;
import com.example.deliveryexample.core.domain.Order;
import com.example.deliveryexample.infrastructure.primary.rest.mapper.DelivererResponseMapper;
import com.example.deliveryexample.infrastructure.primary.rest.mapper.OrderRequestMapper;
import com.example.deliveryexample.infrastructure.primary.rest.request.OrderRequest;
import com.example.deliveryexample.infrastructure.primary.rest.response.DelivererResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {

    private final DelivererResponseMapper delivererMapper;
    private final OrderRequestMapper orderMapper;
    private final NewOrderToDeliver useCase;

    @PostMapping
    public DelivererResponse newOrderArrived(@RequestBody OrderRequest request) {

        Order order = orderMapper.toModel(request);

        Deliverer deliverer = useCase.sendDelivery(order);

        return delivererMapper.toResponse(deliverer);
    }

}
