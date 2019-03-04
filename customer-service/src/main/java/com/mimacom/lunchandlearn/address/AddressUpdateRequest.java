package com.mimacom.lunchandlearn.address;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressUpdateRequest {

    private final String streetName;

    private final String streetNr;

    private final String postCode;

    private final String city;

    private final String canton;

}
