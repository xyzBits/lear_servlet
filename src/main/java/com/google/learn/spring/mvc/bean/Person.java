package com.google.learn.spring.mvc.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private static final Logger LOGGER = LoggerFactory.getLogger(Person.class);

    @Autowired
    Car car;

    public Person() {
        LOGGER.info(this.getClass().getClassLoader().toString());
        LOGGER.info("I am  invoked");
    }


    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Person{" +
                "car=" + car +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
