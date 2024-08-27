package com.example.ecommerceapi.repository;

import com.example.ecommerce.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository<Coupon> extends JpaRepository<Coupon, Long> {
}
