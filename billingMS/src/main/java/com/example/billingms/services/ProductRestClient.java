package com.example.billingms.services;

import com.example.billingms.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductRestClient {

    @GetMapping("/products/{id}")
    Product findProductById(@PathVariable Long id);

    @GetMapping("/products")
    PagedModel<Product> allProducts();
}
