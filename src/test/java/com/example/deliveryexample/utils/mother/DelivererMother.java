package com.example.deliveryexample.utils.mother;

import com.example.deliveryexample.core.domain.Deliverer;
import com.example.deliveryexample.infrastructure.secundary.db.entity.DelivererEntity;
import org.jetbrains.annotations.NotNull;

public class DelivererMother {

    private static final String NAME = "Tester";
    private static final String RUT = "1111111-1";

    public static Deliverer model() {
        return new Deliverer(NAME, RUT);
    }

    @NotNull
    public static DelivererEntity entity() {
        return DelivererEntity.from(NAME, RUT);
    }
}
