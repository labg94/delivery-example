package com.example.deliveryexample.infrastructure.secundary.db.repository;

import com.example.deliveryexample.core.domain.Restaurant;
import com.example.deliveryexample.core.errors.RestaurantNotfound;
import com.example.deliveryexample.infrastructure.secundary.db.dao.RestaurantData;
import com.example.deliveryexample.infrastructure.secundary.db.mapper.RestaurantMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.deliveryexample.utils.mother.RestaurantMother.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RestaurantMongoRepositoryTest {

    @Mock
    private RestaurantData data;
    @Mock
    private RestaurantMapper mapper;

    @InjectMocks
    private RestaurantMongoRepository repository;


    @Test
    @DisplayName("Given a restaurant name that exist should return the restaurant")
    void validRestaurant() {
        when(data.findFirstByName(RESTAURANT_NAME)).thenReturn(Optional.of(entity()));
        when(mapper.toDomain(entity())).thenReturn(model());

        Restaurant actual = repository.findRestaurantByName(RESTAURANT_NAME);

        assertEquals(model(), actual);
        verify(data, times(1)).findFirstByName(RESTAURANT_NAME);
        verify(mapper, times(1)).toDomain(entity());

    }

    @Test
    @DisplayName("When search for an invalid name should throw an exception")
    void invalidRestaurant() {
        String invalidName = "invalid";
        when(data.findFirstByName(invalidName)).thenReturn(Optional.empty());


        var exception = assertThrows(RestaurantNotfound.class, () -> repository.findRestaurantByName(invalidName));


        String expectedMessage = String.format("Restaurant with name: %s does not exist", invalidName);
        assertEquals(expectedMessage,exception.getMessage());
        verify(mapper, never()).toDomain(any());
    }
}