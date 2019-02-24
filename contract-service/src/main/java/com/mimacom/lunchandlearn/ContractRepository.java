package com.mimacom.lunchandlearn;

import org.springframework.data.repository.Repository;

public interface ContractRepository extends Repository<Contract, Long> {

    Contract findByCustomerId(Long customerId);

    void save(Contract contract);

}
