package com.mimacom.lunchandlearn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AddressUpdateService {


    public void process(AddressUpdateEvent event) {



    }

    private boolean movingFromZurichToBern(AddressUpdateEvent event) {
        return "Zurich".equals(event.getCurrentAddress().getCity()) && "Bern".equals(event.getNewAddress().getCity());
    }

    private boolean movingFromBernToZurich(AddressUpdateEvent event) {
        return "Bern".equals(event.getCurrentAddress().getCity()) && "Zurich".equals(event.getNewAddress().getCity());
    }

}
