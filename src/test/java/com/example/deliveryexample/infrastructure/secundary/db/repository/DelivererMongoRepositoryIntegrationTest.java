package com.example.deliveryexample.infrastructure.secundary.db.repository;

import com.example.deliveryexample.core.domain.Deliverer;
import com.example.deliveryexample.core.errors.UnavailableDeliverers;
import com.example.deliveryexample.core.secundary.DelivererRepository;
import com.example.deliveryexample.infrastructure.secundary.db.dao.DelivererData;
import com.example.deliveryexample.infrastructure.secundary.db.entity.DelivererEntity;
import com.example.deliveryexample.infrastructure.secundary.db.mapper.DelivererMapper;
import com.example.deliveryexample.infrastructure.secundary.db.mapper.DelivererMapperImpl;
import com.example.deliveryexample.utils.mother.DelivererMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class DelivererMongoRepositoryIntegrationTest {

    @Autowired
    private DelivererData delivererData;
    @Autowired
    private DelivererRepository delivererRepository;

    @BeforeEach
    void setUp() {
        delivererData.deleteAll();
    }

    @Test
    void findADeliverer() {
        DelivererEntity entity = DelivererMother.entity();
        delivererData.save(entity);

        Deliverer availableDelivery = delivererRepository.findAvailableDelivery();

        assertNotNull(availableDelivery);
        assertEquals(entity.name(), availableDelivery.name());
        assertEquals(entity.rut(), availableDelivery.rut());
        assertNull(availableDelivery.foodToDeliver());

    }

    @Test
    void notFound() {


        UnavailableDeliverers unavailableDeliverers =
                assertThrows(UnavailableDeliverers.class, () -> delivererRepository.findAvailableDelivery());

        String expectedMessage = "There are not available deliverers";
        assertEquals(expectedMessage,unavailableDeliverers.getMessage());

    }

    @TestConfiguration
    static class Config {

        @Bean
        DelivererMapper delivererMapper() {
            return new DelivererMapperImpl();
        }

        @Bean
        DelivererRepository delivererRepository(DelivererMapper delivererMapper, DelivererData delivererData) {
            return new DelivererMongoRepository(delivererMapper, delivererData);
        }
    }
}