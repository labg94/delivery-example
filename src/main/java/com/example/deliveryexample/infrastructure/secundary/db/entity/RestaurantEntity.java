package com.example.deliveryexample.infrastructure.secundary.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collation = "Restaurant")
public record RestaurantEntity(@Id String id, String name, String rut, List<Plate> plates) {
}
