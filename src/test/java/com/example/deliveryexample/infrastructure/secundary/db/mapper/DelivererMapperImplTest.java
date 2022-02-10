package com.example.deliveryexample.infrastructure.secundary.db.mapper;

import com.example.deliveryexample.utils.mother.DelivererMother;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelivererMapperImplTest {

    private final DelivererMapper mapper = new DelivererMapperImpl();


    @Test
    @DisplayName("Given an entity should return a model")
    void map() {
        assertEquals(DelivererMother.model(), mapper.toModel(DelivererMother.entity()));
    }

}