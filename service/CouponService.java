package com.example.ecommerceapi.service;

import com.example.ecommerce.dto.*;
import com.example.ecommerce.model.Coupon;
import com.example.ecommerce.repository.CouponRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {
    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Coupon createCoupon(CouponDto couponDto) {
        Coupon coupon = new Coupon();
        coupon.setType(CouponType.valueOf(couponDto.getType().toUpperCase()));
        coupon.setDetails((Map<String, Object>) couponDto.getDetails());
        coupon.setRepetitionLimit(couponDto.getRepetitionLimit());
        return couponRepository.save(coupon);
    }

    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    public Coupon getCouponById(Long id) {
        return couponRepository.findById(id)
                .orElseThrow(() -> new CouponNotFoundException("Coupon not found with ID: " + id));
    }

    public Coupon updateCoupon(Long id, CouponDto couponDto) {
        Coupon coupon = getCouponById(id);
        coupon.setType(CouponType.valueOf(couponDto.getType().toUpperCase()));
        coupon.setDetails((Map<String, Object>) couponDto.getDetails());
        coupon.setRepetitionLimit(couponDto.getRepetitionLimit());
        return couponRepository.save(coupon);
    }

    public void deleteCoupon(Long id) {
        Coupon coupon = getCouponById(id);
        couponRepository.delete(coupon);
    }
}
