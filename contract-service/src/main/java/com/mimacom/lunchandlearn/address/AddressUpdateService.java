package com.mimacom.lunchandlearn.address;

import com.mimacom.lunchandlearn.ContractRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressUpdateService {

    private final ContractRepository contractRepository;

    public AddressUpdateService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public void process(AddressUpdateEvent event) {

        if (movingFromZurichToBern(event)) {
            contractRepository.updateBasicInsurancePrice(event.getCustomerId(), 25.0);
        }
        if (movingFromBernToZurich(event)) {
            contractRepository.updateBasicInsurancePrice(event.getCustomerId(), -25.0);
        }

    }

    private boolean movingFromZurichToBern(AddressUpdateEvent event) {
        return "Zurich".equals(event.getCurrentAddress().getCity()) && "Bern".equals(event.getNewAddress().getCity());
    }

    private boolean movingFromBernToZurich(AddressUpdateEvent event) {
        return "Bern".equals(event.getCurrentAddress().getCity()) && "Zurich".equals(event.getNewAddress().getCity());
    }

}
