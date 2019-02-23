package com.mimacom.lunchandlearn.address;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerAddressRestController {

    @PatchMapping("/customers/{customerId}/address")
    public ResponseEntity<Void> updateCustomerAddress(@PathVariable Long customerId,
                                                      @RequestBody AddressUpdateRequest addressUpdateRequest) {
        return ResponseEntity.accepted().build();
    }

}
