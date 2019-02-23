package com.mimacom.lunchandlearn;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final ContractServiceClient contractServiceClient;

    public CustomerService(CustomerRepository customerRepository, ContractServiceClient contractServiceClient) {
        this.customerRepository = customerRepository;
        this.contractServiceClient = contractServiceClient;
    }

    public Customer getCustomer(Long customerId) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("customer with id '" + customerId + "' not found");
        }
        Contract contract = contractServiceClient.getContract(customerId);
        // put contract information into customer
        return customer;
    }
}
