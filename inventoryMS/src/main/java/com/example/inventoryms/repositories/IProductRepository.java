package com.example.inventoryms.repositories;

import com.example.inventoryms.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IProductRepository extends JpaRepository<Product, Long> {
}
