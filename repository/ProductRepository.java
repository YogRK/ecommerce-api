package com.example.ecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository<Product> extends JpaRepository<Product, Long> {
}
