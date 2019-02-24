package com.mimacom.lunchandlearn;

import com.mimacom.lunchandlearn.Contract.Product;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer {

    private final ContractRepository contractRepository;

    public DataInitializer(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        contractRepository.save(new Contract(
                1L,
                Arrays.asList(
                    new Product("Basic health insurance casamed family doctor", 295.60),
                    new Product("Supplementary outpatient insurance plus", 19.60),
                    new Product("Supplementary hospital insurance hospita general", 9.40),
                    new Product("Supplementary dental insurance dental", 26.00),
                    new Product("Legal expenses insurance in health matters protect", 1.50)
                )
                ));

    }
}

