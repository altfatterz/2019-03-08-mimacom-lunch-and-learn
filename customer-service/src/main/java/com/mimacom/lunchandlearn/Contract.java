package com.mimacom.lunchandlearn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contract {

    private List<Product> products;

    @Data
    static class Product {

        private String name;

        private double price;
    }

}
