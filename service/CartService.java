package com.example.ecommerceapi.service;

import com.example.ecommerce.dto.*;
import com.example.ecommerce.model.Coupon;
import com.example.ecommerce.repository.CouponRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CouponRepository couponRepository;

    public CartService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public List<CouponDto> getApplicableCoupons(CartDto cart) {
        // Logic to fetch and calculate applicable coupons for the given cart
    }

    public CartDto applyCoupon(Long couponId, CartDto cart) {
        // Logic to apply the coupon to the cart and return the updated cart
    }
}
