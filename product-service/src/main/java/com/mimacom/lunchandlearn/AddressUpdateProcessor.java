package com.mimacom.lunchandlearn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AddressUpdateProcessor {

    private final ProductPriceService productPriceService;

    public AddressUpdateProcessor(ProductPriceService productPriceService) {
        this.productPriceService = productPriceService;
    }

    @StreamListener(Sink.INPUT)
    public void processAddressUpdate(AddressUpdateEvent event) {
        log.info("processing event {}", event);
        if (!event.isSameRegion()) {
            productPriceService.updateProductPriceForCustomer(event.getCustomerId());
        }
    }

}
