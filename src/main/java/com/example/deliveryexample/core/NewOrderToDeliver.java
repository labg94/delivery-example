package com.example.deliveryexample.core;

import com.example.deliveryexample.core.domain.Deliverer;
import com.example.deliveryexample.core.domain.Order;

public interface NewOrderToDeliver {
    Deliverer sendDelivery(Order order);
}
