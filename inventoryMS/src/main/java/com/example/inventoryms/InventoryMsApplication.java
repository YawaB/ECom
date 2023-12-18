package com.example.inventoryms;

import com.example.inventoryms.entities.Product;
import com.example.inventoryms.repositories.IProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InventoryMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryMsApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IProductRepository productRepository, RepositoryRestConfiguration restConfiguration) {
        return args -> {

            restConfiguration.exposeIdsFor(Product.class);
            productRepository.saveAll(
                    List.of(
                            Product.builder().name("Computer").price(1000).quantity(10).build(),
                            Product.builder().name("Printer").price(200).quantity(20).build(),
                            Product.builder().name("Phone").price(300).quantity(30).build()
                    )
            );
            productRepository.findAll().forEach(System.out::println);
        };
    }

}
