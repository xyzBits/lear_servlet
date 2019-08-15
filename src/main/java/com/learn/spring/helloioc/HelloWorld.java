package com.learn.spring.helloioc;

public class HelloWorld {
    private String name;

    public HelloWorld() {
        System.out.println("No args constructor");
    }

    public HelloWorld(String name) {
        System.out.println("With args constructor");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName() method");
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello " + this.name);
    }
}
