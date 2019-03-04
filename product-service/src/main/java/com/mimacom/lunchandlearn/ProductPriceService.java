package com.mimacom.lunchandlearn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class ProductPriceService {

    private final Set<Long> customersWithProductPriceChanged = new HashSet<>();

    public void updateProductPriceForCustomer(Long customerId) {
        log.info("Update product price for customer {}", customerId);
        // business logic goes here
        customersWithProductPriceChanged.add(customerId);
    }

    public Set<Long> getCustomersWithProductPriceChanged() {
        return customersWithProductPriceChanged;
    }
}
