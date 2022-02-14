package com.example.deliveryexample.infrastructure.primary.rest.response;

import lombok.*;


//@Data
//@AllArgsConstructor
//@NoArgsConstructor //if it is not added the serialization crashs
//public class DelivererResponse {
//    private String name;
//    private String rut;
//    private Dish dish;
//}

public record DelivererResponse(
        String name,
        String rut,
        Dish dish
) {
}
