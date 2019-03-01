package com.mimacom.lunchandlearn.address;

import com.mimacom.lunchandlearn.ContractRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class AddressUpdateService {

    private final Set<String> ZURICH_POSTCODES = new HashSet<>(Arrays.asList(
            "8057", "8045", "8008", "8001", "8003", "8038", "8049", "8064"
            ));

    private final Set<String> BERN_POSTCODES = new HashSet<>(Arrays.asList(
            "3001", "3006", "3010", "3013", "3018", "3027", "3011", "3014"
    ));

    private final ContractRepository contractRepository;

    public AddressUpdateService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public void process(AddressUpdateEvent event) {

        if (movingFromZurichToBern(event)) {
            contractRepository.updateBasicInsurancePrice(event.getCustomerId(), 30.0);
        }
        if (movingFromBernToZurich(event)) {
            contractRepository.updateBasicInsurancePrice(event.getCustomerId(), -30.0);
        }

    }

    private boolean movingFromZurichToBern(AddressUpdateEvent event) {
        return ZURICH_POSTCODES.contains(event.getCurrentAddress().getPostCode())
                && (BERN_POSTCODES.contains(event.getNewAddress().getPostCode()));
    }

    private boolean movingFromBernToZurich(AddressUpdateEvent event) {
        return BERN_POSTCODES.contains(event.getCurrentAddress().getPostCode()) &&
                (ZURICH_POSTCODES.contains(event.getNewAddress().getPostCode()));
    }

}
