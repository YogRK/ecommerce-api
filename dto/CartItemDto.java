package com.example.ecommerce.dto;

import lombok.Data;

@Data
public class CartItemDto {
    private Long productId;
    private int quantity;
    private double price;
}
