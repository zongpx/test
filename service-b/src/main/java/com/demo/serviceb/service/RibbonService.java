package com.demo.serviceb.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService implements IRibbonService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Override
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    }, fallbackMethod = "ribbonFallback")
    public String call() {
        this.loadBalancerClient.choose("service-a");
        return restTemplate.getForObject("http://service-a/sva/ctl/foo", String.class);
    }

    public String ribbonFallback() {
        return "ribbon error";
    }
}