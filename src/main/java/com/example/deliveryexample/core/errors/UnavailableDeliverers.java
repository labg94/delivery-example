package com.example.deliveryexample.core.errors;

public class UnavailableDeliverers  extends RuntimeException {

    public UnavailableDeliverers() {
        super("There are not available deliverers");
    }
}
