package com.mimacom.lunchandlearn.address;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressUpdateEvent {

    private Long customerId;

    private Address currentAddress;

    private Address newAddress;

    @Data
    @Builder
    static class Address {

        private String streetName;

        private String streetNr;

        private String postCode;

        private String city;

    }
}
