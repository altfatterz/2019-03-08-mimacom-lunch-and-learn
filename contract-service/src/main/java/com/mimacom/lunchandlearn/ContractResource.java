package com.mimacom.lunchandlearn;

import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

@Getter
public class ContractResource extends ResourceSupport {

    private final List<Product> products;

    public ContractResource(List<Product> products) {
        this.products = products;
    }

    @Getter
    static class Product {

        private String name;

        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

    }
}
