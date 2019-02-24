package com.mimacom.lunchandlearn;

import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class CustomerResource extends ResourceSupport {

    private String name;

    private LocalDate birthDate;

    private String mobile;

    private String email;

    private Gender gender;

    private Address address;

    private Contract contract;

    @Data
    @Builder
    static class Address {

        private String streetName;

        private String streetNr;

        private String postCode;

        private String city;

    }

    @Data
    @Builder
    static class Contract {

        private List<String> products;
    }

}
