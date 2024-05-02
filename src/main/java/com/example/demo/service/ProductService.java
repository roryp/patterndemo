package com.example.demo.service;

import com.example.demo.model.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private boolean failForCircuitBreakerTest = false; // Default is false to not force failures

    @CircuitBreaker(name = "default", fallbackMethod = "fallback")
    @Retry(name = "default")
    public Product getProductById(Long id) {
        // Simulate a call to a remote service which might fail
        if (failForCircuitBreakerTest || Math.random() > 0.7) {
            throw new RuntimeException("Service failure - Circuit breaker activated");
        }
        return new Product(id, "Product Name", "Product Description");
    }

    public Product fallback(Long id, Throwable t) {
        return new Product(id, "Fallback Product", "Default Description");
    }

    public void setFailForCircuitBreakerTest(boolean fail) {
        this.failForCircuitBreakerTest = fail;
    }
}
