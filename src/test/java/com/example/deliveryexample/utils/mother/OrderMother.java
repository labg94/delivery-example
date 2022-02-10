package com.example.deliveryexample.utils.mother;

import com.example.deliveryexample.core.domain.Order;
import com.example.deliveryexample.infrastructure.primary.rest.request.OrderRequest;

public class OrderMother {
    public static OrderRequest orderRequest() {
        return new OrderRequest("Beans", "Le test");
    }

    public static Order order() {
        return new Order("Beans", "Le test");
    }
}
