package com.mimacom.lunchandlearn.customer;

import com.mimacom.lunchandlearn.customer.Customer;
import org.springframework.data.repository.Repository;

public interface CustomerRepository extends Repository<Customer, Long> {

    Customer findById(Long id);
}
