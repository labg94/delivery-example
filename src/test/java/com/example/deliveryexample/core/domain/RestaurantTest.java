package com.example.deliveryexample.core.domain;

import com.example.deliveryexample.core.errors.PlateNotFound;
import com.example.deliveryexample.utils.mother.FoodMother;
import com.example.deliveryexample.utils.mother.RestaurantMother;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RestaurantTest {

    private final Restaurant restaurant = RestaurantMother.createRestaurant();


    @Test
    @DisplayName("Given the plate name should be cooked")
    void cookAPlate() {
//      GIVEN
        String plateName = FoodMother.pasta().name();

//      WHEN
        Food food = restaurant.cookPlate(plateName);

//      THEN
        assertEquals(FoodMother.pasta(), food);
    }


    @Test
    @DisplayName("Given a plate name that the restaurant does not cook, should throw an exception")
    void invalidPlate() {

        String invalidPlateName = "Guasacaca";

        PlateNotFound plateNotFound = assertThrows(PlateNotFound.class, () -> restaurant.cookPlate(invalidPlateName));


        String expectedErrorMessage = String.format("The plate %s cannot be cooked in the restaurant selected %s",
                invalidPlateName,
                restaurant.name());


        assertEquals(expectedErrorMessage, plateNotFound.getMessage());
    }
}