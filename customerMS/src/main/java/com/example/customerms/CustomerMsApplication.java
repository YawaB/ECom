package com.example.customerms;

import com.example.customerms.entities.Customer;
import com.example.customerms.repositories.ICustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerMsApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ICustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration) {
        return args -> {
            restConfiguration.exposeIdsFor(Customer.class);
            customerRepository.saveAll(
                    List.of(
                            Customer.builder().name("hassan").email("hassan@isga.ma").build(),
                            Customer.builder().name("youssef").email("youss@isga.ma").build(),
                            Customer.builder().name("yawa").email("yawab@isga.ma").build()
                    )
            );
            customerRepository.findAll().forEach(System.out::println);
        };
    }

}
