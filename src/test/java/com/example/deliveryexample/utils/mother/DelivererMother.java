package com.example.deliveryexample.utils.mother;

import com.example.deliveryexample.core.domain.Deliverer;
import com.example.deliveryexample.core.domain.Food;
import com.example.deliveryexample.infrastructure.primary.rest.response.DelivererResponse;
import com.example.deliveryexample.infrastructure.primary.rest.response.Dish;
import com.example.deliveryexample.infrastructure.secundary.db.entity.DelivererEntity;
import org.jetbrains.annotations.NotNull;

public class DelivererMother {

    private static final String NAME = "Tester";
    private static final String RUT = "1111111-1";

    public static Deliverer model() {
        return new Deliverer(NAME, RUT, null);
    }

    public static Deliverer model(Food food) {
        return new Deliverer(NAME, RUT, food);
    }

    public static DelivererEntity entity() {
        return DelivererEntity.from(NAME, RUT);
    }

    public static DelivererResponse response(Dish dish) {
        return new DelivererResponse(NAME, RUT, dish);
    }

}
