package com.mimacom.lunchandlearn.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contract {

    private LocalDate validFrom;

    private List<Product> products;

    @Data
    static class Product {

        private String name;

        private String type;

        private Double price;
    }

}
