package com.mimacom.lunchandlearn;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class BaseContractTest {

    @Autowired
    private ContractRepository contractRepository;

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new ContractRestController(contractRepository));
    }
}
