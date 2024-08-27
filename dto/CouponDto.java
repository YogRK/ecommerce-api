package com.example.ecommerceapi.dto;

import lombok.Data;

@Data
public class CouponDto {
    private String type;
    private Object details;
    private Integer repetitionLimit;
}
