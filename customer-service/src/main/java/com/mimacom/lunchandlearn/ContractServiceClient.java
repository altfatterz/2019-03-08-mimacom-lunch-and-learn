package com.mimacom.lunchandlearn;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ContractServiceClient {

    private final RestTemplate restTemplate;

    public ContractServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Contract getContract(Long customerId) {
        return null;
    }
}
