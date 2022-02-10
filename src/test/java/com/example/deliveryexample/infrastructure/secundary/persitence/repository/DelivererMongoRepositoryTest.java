package com.example.deliveryexample.infrastructure.secundary.persitence.repository;

import com.example.deliveryexample.core.domain.Deliverer;
import com.example.deliveryexample.core.errors.UnavailableDeliverers;
import com.example.deliveryexample.infrastructure.secundary.persitence.dao.DelivererData;
import com.example.deliveryexample.infrastructure.secundary.persitence.mapper.DelivererMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.deliveryexample.utils.mother.DelivererMother.entity;
import static com.example.deliveryexample.utils.mother.DelivererMother.model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DelivererMongoRepositoryTest {

    @Mock
    private DelivererData data;
    @Mock
    private DelivererMapper mapper;
    @InjectMocks
    private DelivererMongoRepository repository;


    @Test
    @DisplayName("if there is a Deliverer available should be returned")
    void delivererFound() {
        when(data.findFirstByAvailableTrue()).thenReturn(Optional.of(entity()));
        when(mapper.toModel(entity())).thenReturn(model());

        Deliverer availableDelivery = repository.findAvailableDelivery();

        assertEquals(model(), availableDelivery);
        verify(data, times(1)).findFirstByAvailableTrue();
        verify(mapper, times(1)).toModel(entity());

    }

    @Test
    @DisplayName("When de deliverer is not found should throw an exception")
    void delivererNotFound() {
        when(data.findFirstByAvailableTrue()).thenReturn(Optional.empty());


        var exception = assertThrows(UnavailableDeliverers.class, () -> repository.findAvailableDelivery());

        String expectedMessage = "There are not available deliverers";
        assertEquals(expectedMessage, exception.getMessage());

        verify(data, times(1)).findFirstByAvailableTrue();
        verify(mapper, never()).toModel(any());
    }
}