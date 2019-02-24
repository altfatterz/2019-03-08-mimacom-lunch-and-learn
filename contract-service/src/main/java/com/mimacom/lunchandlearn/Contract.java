package com.mimacom.lunchandlearn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
public class Contract {

    @Id
    private String id;

    private Long customerId;

    private List<Product> products;

    public Contract(Long customerId, List<Product> products) {
        this.customerId = customerId;
        this.products = products;
    }

    @Getter
    @AllArgsConstructor
    static class Product {

        private String name;

        private double price;

    }
}
