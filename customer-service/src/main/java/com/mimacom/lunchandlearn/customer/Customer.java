package com.mimacom.lunchandlearn.customer;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "customers")
public class Customer {

    @Id
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String mobile;

    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "street_nr")
    private String streetNr;

    @Column(name = "postcode")
    private String postCode;

    private String city;

    private String canton;

    @Transient
    private Contract contract;

    @Data
    @AllArgsConstructor
    static class Contract {

        private LocalDate validFrom;

        private List<String> products;

        private Double monthlyPremium;

    }

    enum Gender {
        MALE, FEMALE
    }
}
