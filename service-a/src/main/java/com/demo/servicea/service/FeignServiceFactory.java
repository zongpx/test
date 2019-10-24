package com.demo.servicea.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceFactory implements FallbackFactory<IFeignService> {

    private final FeignServiceFallBack feignServiceFallBack;

    public FeignServiceFactory(FeignServiceFallBack feignServiceFallBack) {
        this.feignServiceFallBack = feignServiceFallBack;
    }

    @Override
    public IFeignService create(Throwable cause) {
        //打印下异常
        cause.printStackTrace();
        return feignServiceFallBack;
    }
}