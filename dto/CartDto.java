package com.example.ecommerceapi.dto;

import com.example.ecommerceapi.dto.CartItemDto;
import lombok.Data;
import java.util.List;

@Data
public class CartDto {
    private List<CartItemDto> items;
}
