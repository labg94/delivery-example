package com.example.deliveryexample.infrastructure.primary.rest.mapper;

import com.example.deliveryexample.core.domain.Deliverer;
import com.example.deliveryexample.infrastructure.primary.rest.response.DelivererResponse;
import com.example.deliveryexample.infrastructure.primary.rest.response.Dish;
import com.example.deliveryexample.utils.mother.DelivererMother;
import com.example.deliveryexample.utils.mother.FoodMother;
import org.junit.jupiter.api.Test;

import static com.example.deliveryexample.utils.mother.DelivererMother.model;
import static com.example.deliveryexample.utils.mother.FoodMother.pasta;
import static com.example.deliveryexample.utils.mother.FoodMother.pastaAsDish;
import static org.junit.jupiter.api.Assertions.*;

class DelivererResponseMapperImplTest {

    private final DelivererResponseMapper mapper = new DelivererResponseMapperImpl();


    @Test
    void deliveryWithFood() {

        Deliverer delivererWithFood = model(pasta());

        DelivererResponse delivererResponse = mapper.toResponse(delivererWithFood);


        assertEquals(DelivererMother.response(pastaAsDish()), delivererResponse);

    }
}