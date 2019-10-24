package com.demo.servicea.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("fallback/")
public class FeignServiceFallBack implements IFeignService {
    @Override
    public String call() {
        return "feign error";
    }
}
