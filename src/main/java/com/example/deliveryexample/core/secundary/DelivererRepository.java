package com.example.deliveryexample.core.secundary;

import com.example.deliveryexample.core.domain.Deliverer;

public interface DelivererRepository {


    Deliverer findAvailableDelivery();

}
