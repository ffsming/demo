package com.dubbo.service;

import org.springframework.stereotype.Service;

@Service("ProviderService")
public class ProviderServiceImpl implements ProviderService{

    @Override
    public String dubboTest() {
        return "test dubbo provider";
    }
}
