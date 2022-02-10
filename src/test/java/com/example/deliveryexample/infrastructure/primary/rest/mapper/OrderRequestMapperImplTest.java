package com.example.deliveryexample.infrastructure.primary.rest.mapper;

import com.example.deliveryexample.core.domain.Order;
import com.example.deliveryexample.infrastructure.primary.rest.request.OrderRequest;
import com.example.deliveryexample.utils.mother.OrderMother;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderRequestMapperImplTest {

    private final OrderRequestMapper mapper = new OrderRequestMapperImpl();


    @Test
    @DisplayName("Given a Request should return the model")
    void map() {

        OrderRequest orderRequest = OrderMother.orderRequest();

        Order order = mapper.toModel(orderRequest);

        assertEquals(OrderMother.order(), order);
    }

}