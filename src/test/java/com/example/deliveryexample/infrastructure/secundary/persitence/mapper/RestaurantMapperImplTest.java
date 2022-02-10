package com.example.deliveryexample.infrastructure.secundary.persitence.mapper;

import com.example.deliveryexample.utils.mother.RestaurantMother;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RestaurantMapperImplTest {

    private final RestaurantMapper mapper = new RestaurantMapperImpl();


    @Test
    @DisplayName("Given an entity should return a model")
    void map() {

        assertEquals(RestaurantMother.model(), mapper.toDomain(RestaurantMother.entity()));

    }

}