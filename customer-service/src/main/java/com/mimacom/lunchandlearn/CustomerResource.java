package com.mimacom.lunchandlearn;

import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

import java.time.LocalDate;

@Data
@Builder
public class CustomerResource extends ResourceSupport {

    private String name;

    private LocalDate birthDate;

    private String mobile;

    private String email;

    private Gender gender;

    private Address address;

    @Data
    @Builder
    static class Address {

        private String streetName;

        private String streetNr;

        private String postCode;

        private String city;

    }


}
