package com.mimacom.lunchandlearn.customer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        customer.setContract(mapContract(contract));
        return customer;
    }

    private Customer.Contract mapContract(Contract contract) {
        List<String> products = contract.getProducts().stream()
                .map(product -> product.getName() + " " + product.getType() + " --- CHF " + product.getPrice())
                .collect(Collectors.toList());
        return new Customer.Contract(contract.getValidFrom(), products);
    }
}
