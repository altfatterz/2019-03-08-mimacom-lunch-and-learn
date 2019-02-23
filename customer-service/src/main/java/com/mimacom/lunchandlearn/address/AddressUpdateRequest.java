package com.mimacom.lunchandlearn.address;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddressUpdateRequest {

    private final String streetName;

    private final String streetNr;

    private final String zipCode;

    private final String city;

}
