package com.mimacom.lunchandlearn.address;

import com.mimacom.lunchandlearn.address.AddressUpdateEvent.Address;
import com.mimacom.lunchandlearn.customer.Customer;
import com.mimacom.lunchandlearn.customer.CustomerRepository;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class AddressUpdateService {

    private final Source source;

    private final CustomerRepository customerRepository;

    public AddressUpdateService(Source source, CustomerRepository customerRepository) {
        this.source = source;
        this.customerRepository = customerRepository;
    }

    public void updateAddress(Long customerId, AddressUpdateRequest request) {

        Customer customer = customerRepository.findById(customerId);

        AddressUpdateEvent event = buildEvent(customerId, customer, request);

        customer.setStreetName(request.getStreetName());
        customer.setStreetNr(request.getStreetNr());
        customer.setCity(request.getCity());
        customer.setPostCode(request.getPostCode());

        customerRepository.save(customer);

        source.output().send(MessageBuilder.withPayload(event).build());
    }

    private AddressUpdateEvent buildEvent(Long customerId, Customer customer, AddressUpdateRequest request) {
        return AddressUpdateEvent.builder()
                .customerId(customerId)
                .currentAddress(Address.builder()
                        .streetName(customer.getStreetName())
                        .streetNr(customer.getStreetNr())
                        .city(customer.getCity())
                        .postCode(customer.getPostCode())
                        .build())
                .newAddress(Address.builder()
                        .streetName(request.getStreetName())
                        .streetNr(request.getStreetNr())
                        .city(request.getCity())
                        .postCode(request.getPostCode())
                        .build()
                )
                .build();
    }

}
