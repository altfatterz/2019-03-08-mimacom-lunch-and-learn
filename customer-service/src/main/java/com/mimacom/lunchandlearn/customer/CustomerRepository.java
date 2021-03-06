package com.mimacom.lunchandlearn.customer;

import org.springframework.data.repository.Repository;

public interface CustomerRepository extends Repository<Customer, Long> {

    Customer findById(Long id);

    void save(Customer customer);
}
