package com.example.demo.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;

@Service
public class ProductService {

    @CircuitBreaker(name = "default", fallbackMethod = "fallback")
    @Retry(name = "default")
    public Product getProductById(Long id) {
        // Simulate a call to a remote service which might fail
        if (Math.random() > 0.7) {
            throw new RuntimeException("Service failure");
        }
        return new Product(id, "Product Name", "Product Description");
    }

    public Product fallback(Long id, Throwable t) {
        return new Product(id, "Fallback Product", "Default Description");
    }
}
