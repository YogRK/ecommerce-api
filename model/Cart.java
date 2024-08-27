package com.example.ecommerceapi.model;

import com.example.ecommerceapi.model.CartItem;
import lombok.Data;
import java.util.List;

@Data
public class Cart {
    private List<CartItem> items;
}
