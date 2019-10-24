package com.demo.serviceb.controller;

import com.demo.serviceb.service.IRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("svb/ctl/")
public class DemoController {

    @Autowired
    private IRibbonService ribbonService;

    @GetMapping("foo")
    public String foo() {
        return "find service b foo bar-b";
    }

    @GetMapping("ribbon/foo")
    public String ribbonFoo() {
        String str = ribbonService.call();
        return "bar-b " + str;
    }
}
