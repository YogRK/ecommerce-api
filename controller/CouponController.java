package com.example.ecommerceapi.controller;

import com.example.ecommerce.dto.*;
import com.example.ecommerce.model.Coupon;
import com.example.ecommerce.service.CartService;
import com.example.ecommerce.service.CouponService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupons")
public class CouponController {
    private final CouponService couponService;
    private final CartService cartService;

    public CouponController(CouponService couponService, CartService cartService) {
        this.couponService = couponService;
        this.cartService = cartService;
    }

    @PostMapping
    public Coupon createCoupon(@RequestBody CouponDto couponDto) {
        return couponService.createCoupon(couponDto);
    }

    @GetMapping
    public List<Coupon> getAllCoupons() {
        return couponService.getAllCoupons();
    }

    @GetMapping("/{id}")
    public Coupon getCouponById(@PathVariable Long id) {
        return couponService.getCouponById(id);
    }

    @PutMapping("/{id}")
    public Coupon updateCoupon(@PathVariable Long id, @RequestBody CouponDto couponDto) {
        return couponService.updateCoupon(id, couponDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCoupon(@PathVariable Long id) {
        couponService.deleteCoupon(id);
    }

    @PostMapping("/applicable-coupons")
    public List<CouponDto> getApplicableCoupons(@RequestBody CartDto cart) {
        return cartService.getApplicableCoupons(cart);
    }

    @PostMapping("/apply-coupon/{id}")
    public CartDto applyCoupon(@PathVariable Long id, @RequestBody CartDto cart) {
        return cartService.applyCoupon(id, cart);
    }
}
