package com.example.deliveryexample.infrastructure.primary.rest.response;


import lombok.*;

public record Dish(String name, Double calories, Boolean isVegan) {
}
