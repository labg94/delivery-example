package com.example.deliveryexample.infrastructure.primary.rest.controller;

import com.example.deliveryexample.core.NewOrderToDeliver;
import com.example.deliveryexample.infrastructure.primary.rest.mapper.DelivererResponseMapper;
import com.example.deliveryexample.infrastructure.primary.rest.mapper.OrderRequestMapper;
import com.example.deliveryexample.infrastructure.primary.rest.response.DelivererResponse;
import com.example.deliveryexample.utils.mother.DelivererMother;
import com.example.deliveryexample.utils.mother.FoodMother;
import com.example.deliveryexample.utils.mother.OrderMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static com.example.deliveryexample.utils.mother.FoodMother.pastaAsDish;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class OrderControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    private NewOrderToDeliver useCase;

    @MockBean
    private OrderRequestMapper orderMapper;

    @MockBean
    private DelivererResponseMapper delivererMapper;


    @Autowired
    private MockMvc mockMvc;


    @Test
    void addingANullValue() throws Exception {
        DelivererResponse expectedResponse = DelivererMother.response(pastaAsDish());

        when(orderMapper.toModel(OrderMother.orderRequest())).thenReturn(OrderMother.order());
        when(delivererMapper.toResponse(DelivererMother.model())).thenReturn(expectedResponse);
        when(useCase.sendDelivery(OrderMother.order())).thenReturn(DelivererMother.model());


        String response = mockMvc
                .perform(
                        post("/orders").content(objectMapper.writeValueAsBytes(OrderMother.orderRequest()))
                                       .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse().getContentAsString();

        DelivererResponse delivererResponse = objectMapper.readValue(response, DelivererResponse.class);


        assertEquals(expectedResponse, delivererResponse);

    }
}