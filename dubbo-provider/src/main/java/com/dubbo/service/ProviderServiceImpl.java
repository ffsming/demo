package com.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.duubo.service.ProviderService;

@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class ProviderServiceImpl implements ProviderService{

    @Override
    public String dubboTest() {
        return "test dubbo provider";
    }
}
