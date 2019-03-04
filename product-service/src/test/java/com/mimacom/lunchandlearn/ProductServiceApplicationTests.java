package com.mimacom.lunchandlearn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = "com.mimacom.lunchandlearn:customer-service")
public class ProductServiceApplicationTests {

    @Autowired
    ProductPriceService productPriceService;

    @Autowired
    StubTrigger stubTrigger;

    @Test
    public void moveToDifferentRegion() {
        stubTrigger.trigger("move_to_different_region");

        assertThat(productPriceService.getCustomersWithProductPriceChanged().size()).isEqualTo(1);
    }

}
