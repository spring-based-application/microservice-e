package com.trl.microservicee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceEApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceEApplication.class, args);
    }

}
