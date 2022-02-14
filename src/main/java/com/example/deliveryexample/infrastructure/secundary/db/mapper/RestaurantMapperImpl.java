package com.example.deliveryexample.infrastructure.secundary.db.mapper;

import com.example.deliveryexample.core.domain.Food;
import com.example.deliveryexample.core.domain.Restaurant;
import com.example.deliveryexample.infrastructure.secundary.db.entity.Plate;
import com.example.deliveryexample.infrastructure.secundary.db.entity.RestaurantEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestaurantMapperImpl implements RestaurantMapper {


    @Override
    public Restaurant toDomain(RestaurantEntity restaurantEntity) {

        List<Food> foods = getFoods(restaurantEntity);

        return new Restaurant(restaurantEntity.name(), restaurantEntity.rut(), foods);
    }

    private List<Food> getFoods(RestaurantEntity restaurantEntity) {
        return restaurantEntity.plates().stream().map(this::plateToFood).toList();
    }

    private Food plateToFood(Plate plate) {
        return new Food(plate.name(), plate.calories(), plate.isVegan());
    }
    
}
