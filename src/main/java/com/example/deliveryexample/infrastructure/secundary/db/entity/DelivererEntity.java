package com.example.deliveryexample.infrastructure.secundary.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Deliverers")
public record DelivererEntity(@Id String id, String name, String rut, boolean available) {

    public  static DelivererEntity from(String name, String rut){
        return new DelivererEntity(null, name, rut, true);
    }

}
