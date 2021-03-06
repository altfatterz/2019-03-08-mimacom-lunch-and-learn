package com.mimacom.lunchandlearn;

import org.springframework.data.repository.Repository;

public interface ContractRepository extends Repository<Contract, Long> {

    void deleteAll();

    Contract findByCustomerId(Long customerId);

    void save(Contract contract);

}
