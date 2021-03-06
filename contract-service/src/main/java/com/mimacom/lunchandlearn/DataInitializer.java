package com.mimacom.lunchandlearn;

import com.mimacom.lunchandlearn.Contract.Product;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

@Component
public class DataInitializer {

    private final ContractRepository contractRepository;

    public DataInitializer(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        contractRepository.deleteAll();

        contractRepository.save(new Contract(
                UUID.randomUUID().toString(),
                LocalDate.of(2017, 1, 3),
                1L,
                Arrays.asList(
                        Product.builder()
                                .id(UUID.randomUUID().toString())
                                .name("Basic health insurance")
                                .type("FAMILY_DOCTOR_MODEL")
                                .isBasic(true)
                                .description("If you’re ill, always go to your chosen family doctor first.")
                                .amount(295.60)
                                .deductible(2500)
                                .withAccidentCover(false)
                                .build(),
                        Product.builder()
                                .id(UUID.randomUUID().toString())
                                .name("Supplementary outpatient insurance")
                                .type("PLUS")
                                .description("Basic supplementary insurance for preventative measures, spectacles, sport and more")
                                .amount(19.60)
                                .build(),
                        Product.builder()
                                .id(UUID.randomUUID().toString())
                                .name("Supplementary hospital insurance")
                                .type("HOSPITA_FLEX")
                                .description("Multiple occupancy rooms across Switzerland")
                                .amount(9.40)
                                .build(),
                        Product.builder()
                                .id(UUID.randomUUID().toString())
                                .name("Supplementary dental insurance")
                                .type("DENTAL")
                                .description("Coverage 50%, max. CHF 1000")
                                .amount(26.00)
                                .build(),
                        Product.builder()
                                .id(UUID.randomUUID().toString())
                                .name("Legal expenses insurance in health matters")
                                .type("PROTECT")
                                .description("Protection in legal disputes with medical service providers regarding health insurance")
                                .amount(1.50)
                                .build())

        ));
    }
}

