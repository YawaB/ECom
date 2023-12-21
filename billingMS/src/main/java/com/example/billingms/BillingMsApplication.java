package com.example.billingms;

import com.example.billingms.entities.Bill;
import com.example.billingms.entities.ProductItem;
import com.example.billingms.models.Customer;
import com.example.billingms.models.Product;
import com.example.billingms.repositories.BillRepositorry;
import com.example.billingms.repositories.ProductItemRepository;
import com.example.billingms.services.CustomerRestClient;
import com.example.billingms.services.ProductRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingMsApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BillRepositorry billRepositorry, ProductItemRepository productItemRepository,
                            CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
        return args -> {
            Collection<Product> products = productRestClient.allProducts().getContent();
            Long customerId = 1L;
            Customer customer = customerRestClient.findCustomerById(customerId);
            if (customer == null) throw new RuntimeException("Customer Not Found");
            Bill bill = new Bill();
            bill.setBillingDate(new Date());
            bill.setCustomerId(customerId);
            Bill savedBill = billRepositorry.save(bill);

            products.forEach(product -> {
                ProductItem productItem = new ProductItem();
                productItem.setBill(savedBill);
                productItem.setProductId(product.getId());
                productItem.setQuantity(1 + new Random().nextInt(10));
                productItem.setPrice(product.getPrice());
                productItem.setDiscount(Math.random());
                productItemRepository.save(productItem);
            });
        };
    }

}
