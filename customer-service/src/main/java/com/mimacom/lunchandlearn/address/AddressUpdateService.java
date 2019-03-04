package com.mimacom.lunchandlearn.address;

import com.mimacom.lunchandlearn.customer.Customer;
import com.mimacom.lunchandlearn.customer.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressUpdateService {

    private final CustomerRepository customerRepository;

    private final AddressUpdateEventProducer addressUpdateEventProducer;

    public AddressUpdateService(CustomerRepository customerRepository, AddressUpdateEventProducer addressUpdateEventProducer) {
        this.customerRepository = customerRepository;
        this.addressUpdateEventProducer = addressUpdateEventProducer;
    }

    public void updateAddress(Long customerId, AddressUpdateRequest request) {

        Customer customer = customerRepository.findById(customerId);

        AddressUpdateEvent event = buildEvent(customerId, customer, request);

        customer.setStreetName(request.getStreetName());
        customer.setStreetNr(request.getStreetNr());
        customer.setCity(request.getCity());
        customer.setPostCode(request.getPostCode());

        customerRepository.save(customer);

        addressUpdateEventProducer.perform(event);
    }

    private AddressUpdateEvent buildEvent(Long customerId, Customer customer, AddressUpdateRequest request) {
        return AddressUpdateEvent.builder()
                .customerId(customerId)
                .currentAddress(AddressUpdateEvent.Address.builder()
                        .streetName(customer.getStreetName())
                        .streetNr(customer.getStreetNr())
                        .city(customer.getCity())
                        .postCode(customer.getPostCode())
                        .build())
                .newAddress(AddressUpdateEvent.Address.builder()
                        .streetName(request.getStreetName())
                        .streetNr(request.getStreetNr())
                        .city(request.getCity())
                        .postCode(request.getPostCode())
                        .build()
                )
                .build();
    }

}
