package com.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.duubo.service.ProviderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestDubboController {

    @Reference(version = "1.0.0")
    private ProviderService providerService;

    @RequestMapping("/dubbo")
    public String sayHello() {
        return providerService.dubboTest();
    }

}
