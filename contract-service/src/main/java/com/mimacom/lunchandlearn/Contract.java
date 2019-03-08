package com.mimacom.lunchandlearn;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class Contract {

    @Id
    private String id;

    private LocalDate validFrom;

    private Long customerId;

    private List<Product> products;

    @Data
    @Builder
    @JsonInclude(Include.NON_NULL)
    static class Product {

        private String id;

        private String name;

        private String description;

        private String type;

        private Boolean isBasic;

        private Double amount;

        private Integer deductible;

        private Boolean withAccidentCover;

    }

}
