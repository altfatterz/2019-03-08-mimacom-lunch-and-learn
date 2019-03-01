package com.mimacom.lunchandlearn.address;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class AddressUpdateEventProducer {

    private final Source source;

    public AddressUpdateEventProducer(Source source) {
        this.source = source;
    }

    public void perform(AddressUpdateEvent event) {
        source.output().send(MessageBuilder.withPayload(event).build());
    }


}
