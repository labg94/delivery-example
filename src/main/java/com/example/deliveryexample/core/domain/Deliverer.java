package com.example.deliveryexample.core.domain;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class Deliverer {
    private final String name;
    private final String rut;
    private final AtomicReference<Food> foodToDeliver = new AtomicReference<>();

    public Deliverer(String name, String rut) {
        this.name = name;
        this.rut = rut;
    }

    public void receiveFood(Food foodToDeliver) {
        this.foodToDeliver.set(foodToDeliver);
    }

    public String name() {
        return name;
    }

    public String rut() {
        return rut;
    }

    public Food foodToDeliver() {
        return foodToDeliver.get();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Deliverer) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.rut, that.rut) &&
                Objects.equals(this.foodToDeliver, that.foodToDeliver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rut, foodToDeliver);
    }

    @Override
    public String toString() {
        return "Deliverer[" +
                "name=" + name + ", " +
                "rut=" + rut + ", " +
                "foodToDeliver=" + foodToDeliver + ']';
    }


}
