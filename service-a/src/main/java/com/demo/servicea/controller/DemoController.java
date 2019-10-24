package com.demo.servicea.controller;

import com.demo.servicea.service.IFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sva/ctl/")
public class DemoController {

    @Autowired
    private IFeignService feignService;

    @GetMapping("feign/foo")
    public String feignFoo() {
        String str = feignService.call();
        return "bar-a " + str;
    }

    @GetMapping("foo")
    public String foo() {
        return "find service a foo bar-a";
    }
}
