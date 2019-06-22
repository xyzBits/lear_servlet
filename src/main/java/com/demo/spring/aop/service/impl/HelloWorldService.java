package com.demo.spring.aop.service.impl;

import com.demo.spring.aop.service.IHelloWorldService;

public class HelloWorldService implements IHelloWorldService {
    @Override
    public void sayHello() {
        System.out.println("hello Spring Aop");
    }
}
