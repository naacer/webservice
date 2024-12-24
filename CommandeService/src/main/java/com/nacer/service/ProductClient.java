package com.nacer.service;

import com.nacer.model.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCT-SERVICE", url = "http://localhost:8081")
public interface ProductClient {
    @GetMapping("/api/produits/{id}")
    ProductDto getProduct(@PathVariable Long id);
}
