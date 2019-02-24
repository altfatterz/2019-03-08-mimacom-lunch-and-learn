package com.mimacom.lunchandlearn.customer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class ContractServiceClient {

    private final RestTemplate restTemplate;

    public ContractServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "reliable")
    public Contract getContract(Long customerId) {
        ResponseEntity<Contract> contract = restTemplate.getForEntity
                ("http://contract-service/contracts?customerId=" + customerId, Contract.class);
        return contract.getBody();
    }

    public Contract reliable(Long customerId) {
        return new Contract(null, Arrays.asList());
    }
}
