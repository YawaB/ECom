package com.example.customerms.repositories;

import com.example.customerms.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ICustomerRepository extends JpaRepository<Customer, Long> {


}
