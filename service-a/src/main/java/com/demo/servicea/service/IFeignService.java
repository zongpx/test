package com.demo.servicea.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "${feign.provider}", fallbackFactory  = FeignServiceFactory.class)
public interface IFeignService {
    @RequestMapping("/svb/ctl/foo")
    String call();
}
