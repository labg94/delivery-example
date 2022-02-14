package com.example.deliveryexample.infrastructure.primary.rest.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class OrderRequest {
    private String food;
    private String restaurant;
}
