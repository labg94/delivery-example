package com.example.deliveryexample.infrastructure.primary.rest.response;


import java.util.Objects;

public class Dish {
    private String name;
    private Double calories;
    private Boolean isVegan;

    public Dish() {
    }

    public Dish(String name, double calories, boolean isVegan) {
        this.name = name;
        this.calories = calories;
        this.isVegan = isVegan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Boolean getVegan() {
        return isVegan;
    }

    public void setVegan(Boolean vegan) {
        isVegan = vegan;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Dish) obj;
        return Objects.equals(this.name, that.name) &&
                Double.doubleToLongBits(this.calories) == Double.doubleToLongBits(that.calories) &&
                this.isVegan == that.isVegan;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, calories, isVegan);
    }

    @Override
    public String toString() {
        return "Dish[" +
                "name=" + name + ", " +
                "calories=" + calories + ", " +
                "isVegan=" + isVegan + ']';
    }

}
