package com.mimacom.lunchandlearn;

import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class ContractRepositoryImpl implements ContractRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    public ContractRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void updateBasicInsurancePrice(Long customerId, Double value) {

        Query query = new Query(new Criteria("customerId").is(customerId))
                .addCriteria(new Criteria("products.isBasic").is(true));

        Update update = new Update().inc("products.$.price", value);

        mongoTemplate.updateFirst(query, update, Contract.class);
    }
}
