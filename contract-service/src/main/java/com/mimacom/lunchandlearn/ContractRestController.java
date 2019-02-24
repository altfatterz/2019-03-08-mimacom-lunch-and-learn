package com.mimacom.lunchandlearn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ContractRestController {

    public ContractRepository contractRepository;

    public ContractRestController(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @GetMapping("/contracts")
    public ContractResource getContract(@RequestParam("customerId") Long customerId) {
        Contract contract = contractRepository.findByCustomerId(customerId);
        return buildContractResource(contract);
    }

    private ContractResource buildContractResource(Contract contract) {
        List<ContractResource.Product> products = contract.getProducts().stream()
                .map(product -> new ContractResource.Product(product.getName(), product.getPrice()))
                .collect(Collectors.toList());

        return new ContractResource(products);
    }
}
