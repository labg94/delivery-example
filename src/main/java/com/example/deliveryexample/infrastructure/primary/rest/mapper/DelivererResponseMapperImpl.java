package com.example.deliveryexample.infrastructure.primary.rest.mapper;

import com.example.deliveryexample.core.domain.Deliverer;
import com.example.deliveryexample.core.domain.Food;
import com.example.deliveryexample.infrastructure.primary.rest.response.DelivererResponse;
import com.example.deliveryexample.infrastructure.primary.rest.response.Dish;
import org.springframework.stereotype.Component;

@Component
public class DelivererResponseMapperImpl implements DelivererResponseMapper {
    @Override
    public DelivererResponse toResponse(Deliverer deliverer) {

        Dish dish = toDish(deliverer.foodToDeliver());

        return new DelivererResponse(deliverer.name(), deliverer.rut(), dish);
    }

    private Dish toDish(Food food) {
        return food != null ? new Dish(food.name(), food.calories(), food.isVegan()) : null;
    }
}
