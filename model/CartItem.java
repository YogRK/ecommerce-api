package com.example.ecommerceapi.model;

import lombok.Data;

@Data
public class CartItem {
    private Long productId;
    private int quantity;
    private double price;
}
