package com.example.billingms.entities;

import com.example.billingms.models.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {
    @Id
    @GeneratedValue
    private Long id;

    private Long customerId;

    private Date billingDate;

    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;

    @Transient //attribut a ignorer lors de la creation de la table
    private Customer customer;

}
