package com.mimacom.lunchandlearn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractRestController {

    public ContractRepository contractRepository;

    public ContractRestController(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @GetMapping("/contracts")
    public Contract getContract(@RequestParam("customerId") Long customerId) {
        return contractRepository.findByCustomerId(customerId);
    }
}
