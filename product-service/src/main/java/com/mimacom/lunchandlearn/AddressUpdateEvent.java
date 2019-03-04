package com.mimacom.lunchandlearn;

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

        private final String canton;

    }

    public boolean isSameRegion() {
        return currentAddress.canton.equals(newAddress.canton);
    }

}
