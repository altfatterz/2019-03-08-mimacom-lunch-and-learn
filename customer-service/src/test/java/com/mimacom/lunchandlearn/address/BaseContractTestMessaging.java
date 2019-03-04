package com.mimacom.lunchandlearn.address;

import com.mimacom.lunchandlearn.CustomerServiceApplication;
import com.mimacom.lunchandlearn.address.AddressUpdateEvent.Address;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerServiceApplication.class)
@AutoConfigureMessageVerifier
public abstract class BaseContractTestMessaging {

    @Autowired
    private AddressUpdateEventProducer addressUpdateEventProducer;

    public void moveToDifferentRegion() {

        AddressUpdateEvent event = AddressUpdateEvent.builder()
                .customerId(2L)
                .currentAddress(Address.builder()
                        .streetName("aaa")
                        .streetNr("123")
                        .city("Zurich")
                        .postCode("8001")
                        .canton("Zurich")
                        .build())
                .newAddress(Address.builder()
                        .streetName("aaa")
                        .streetNr("123")
                        .city("Bern")
                        .postCode("3011")
                        .canton("Bern")
                        .build())
                .build();

        addressUpdateEventProducer.perform(event);

    }

}



