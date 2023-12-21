package com.example.billingms.entities;

import com.example.billingms.models.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductItem {
    @Id
    @GeneratedValue
    Long id;

    Long productId;
    int quantity;
    double price;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Bill bill;

    private double discount;

    @Transient
    private Product product;

    public double getTotalPrice() {
        return quantity * price;
    }


}
