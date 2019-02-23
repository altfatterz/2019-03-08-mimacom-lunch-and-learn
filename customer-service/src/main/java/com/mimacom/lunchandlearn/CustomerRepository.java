package com.mimacom.lunchandlearn;

import org.springframework.data.repository.Repository;

public interface CustomerRepository extends Repository<Customer, Long> {

    Customer findById(Long id);
}
