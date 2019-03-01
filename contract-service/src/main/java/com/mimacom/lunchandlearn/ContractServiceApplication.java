package com.mimacom.lunchandlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableBinding(Sink.class)
public class ContractServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContractServiceApplication.class, args);
    }

}
