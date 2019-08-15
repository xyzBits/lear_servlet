package com.learn.spring.mvc.handler;

import com.google.learn.spring.mvc.bean.Car;
import com.google.learn.spring.mvc.bean.Person;
import com.learn.spring.mvc.bean.Car;
import com.learn.spring.mvc.bean.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);

    @Autowired
    Person person;

    @Autowired
    Car car;


    /**
     * @return
     * @see RequestMapping 注解来映射请求的url
     */
    @RequestMapping("/hello")
    public String hello() {
        LOGGER.info("hello world");
        LOGGER.info("this is log ");

        car.setBrand("TOYOTA");
        car.setCompany("Feng tian");
        car.setSalar(332.D);


        LOGGER.info("person is {}", person);

        return "success";
    }

    public static void main(String[] args) {
        LOGGER.info("hello");
    }
}
