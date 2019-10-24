package com.demo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

    @RequestMapping("/hystrixfallback")
    public String hystrixfallback() {
        return "This is a fallback";
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}

