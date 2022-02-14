package com.example.deliveryexample.infrastructure.primary.rest.response;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor //if it is not added the serialization crashs
public class Dish {
    private String name;
    private Double calories;
    private Boolean isVegan;

}
