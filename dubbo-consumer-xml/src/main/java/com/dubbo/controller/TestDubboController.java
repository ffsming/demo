package com.dubbo.controller;

import com.dubbo.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestDubboController {

    @Autowired
    private ProviderService providerService;

    @RequestMapping("/dubbo")
    public String sayHello() {
        return providerService.dubboTest();
    }

}
