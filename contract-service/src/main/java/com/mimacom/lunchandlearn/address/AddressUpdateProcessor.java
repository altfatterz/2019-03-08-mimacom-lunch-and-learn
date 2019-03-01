package com.mimacom.lunchandlearn.address;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AddressUpdateProcessor {

    private final AddressUpdateService addressUpdateService;

    public AddressUpdateProcessor(AddressUpdateService addressUpdateService) {
        this.addressUpdateService = addressUpdateService;
    }

    @StreamListener(Sink.INPUT)
    public void processAddressUpdate(AddressUpdateEvent event) {
        log.info("processing event {}", event);
        addressUpdateService.process(event);
    }

}
