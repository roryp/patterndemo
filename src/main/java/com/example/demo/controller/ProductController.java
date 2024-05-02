package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService2) {
        productService = productService2;
    }

    @GetMapping("/product/{id}")
    @Cacheable("products")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/configure/failure")
    public String configureFailure(@RequestParam boolean fail) {
        productService.setFailForCircuitBreakerTest(fail);
        return "Failure mode is now set to: " + (fail ? "ON" : "OFF");
    }
}
