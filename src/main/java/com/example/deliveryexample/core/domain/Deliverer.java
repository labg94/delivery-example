package com.example.deliveryexample.core.domain;

public record Deliverer(String name, String rut, Food foodToDeliver) {

    public Deliverer receiveFood(Food foodToDeliver) {
        return new Deliverer(this.name, this.rut, foodToDeliver);
    }

}
