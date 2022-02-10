package com.example.deliveryexample.infrastructure.primary.rest.response;

import java.util.Objects;

public class DelivererResponse {
    private  String name;
    private  String rut;
    private  Dish dish;

    public DelivererResponse() {
    }

    public DelivererResponse(String name, String rut, Dish dish) {
        this.name = name;
        this.rut = rut;
        this.dish = dish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DelivererResponse that = (DelivererResponse) o;
        return Objects.equals(name, that.name) && Objects.equals(rut,
                that.rut) && Objects.equals(dish, that.dish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rut, dish);
    }

    @Override
    public String toString() {
        return "DelivererResponse{" +
                "name='" + name + '\'' +
                ", rut='" + rut + '\'' +
                ", dish=" + dish +
                '}';
    }
}
