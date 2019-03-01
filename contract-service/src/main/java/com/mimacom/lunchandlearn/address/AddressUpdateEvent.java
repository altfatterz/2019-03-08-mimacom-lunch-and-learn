package com.mimacom.lunchandlearn.address;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressUpdateEvent {

    private final Long customerId;

    private final Address currentAddress;

    private final Address newAddress;

    @Data
    @AllArgsConstructor
    static class Address {

        private final String streetName;

        private final String streetNr;

        private final String postCode;

        private final String city;

    }
}
