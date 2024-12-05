package org.example.dubbo.spring.demo.provider;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.dubbo.spring.demo.DemoService;

@DubboService
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }


    @Override
    public int getAddition(int a, int b) {
        return a + b;
    }
}
