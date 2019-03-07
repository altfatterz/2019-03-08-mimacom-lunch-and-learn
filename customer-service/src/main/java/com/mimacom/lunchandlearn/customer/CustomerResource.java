package com.mimacom.lunchandlearn.customer;

import com.mimacom.lunchandlearn.customer.Customer.Gender;
import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class CustomerResource extends ResourceSupport {

    private String name;

    private LocalDate birthDate;

    private String mobile;

    private String email;

    private Gender gender;

    private Address address;

    private Contract contract;

    @Getter
    @Builder
    static class Address {

        private String streetName;

        private String streetNr;

        private String postCode;

        private String city;

        private String canton;

    }

    @Getter
    @Builder
    static class Contract {

        private LocalDate validFrom;

        private List<String> products;

        private Double monthlyPremium;
    }

}
