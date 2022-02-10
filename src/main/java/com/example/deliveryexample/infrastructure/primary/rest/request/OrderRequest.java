package com.example.deliveryexample.infrastructure.primary.rest.request;

import java.util.Objects;

public final class OrderRequest {
    private  String food;
    private  String restaurant;

    public OrderRequest() {
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public OrderRequest(String food, String restaurant) {
        this.food = food;
        this.restaurant = restaurant;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRequest that = (OrderRequest) o;
        return Objects.equals(food, that.food) && Objects.equals(restaurant, that.restaurant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(food, restaurant);
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "food='" + food + '\'' +
                ", restaurant='" + restaurant + '\'' +
                '}';
    }
}
