package com.example.ecommerceapi.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Map;

@Entity
@Data
public class Coupon {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CouponType type;

    @ElementCollection
    private Map<String, Object> details;

    private Integer repetitionLimit;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
