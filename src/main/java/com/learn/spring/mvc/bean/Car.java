package com.learn.spring.mvc.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private static final Logger LOGGER = LoggerFactory.getLogger(Car.class);

    private String brand = "toyota ";
    private String company = "japanses";
    private Double salar = 2214.D;

    public Car() {
        LOGGER.info(this.getClass().getClassLoader().toString());
        LOGGER.info("I am  invoked" + this.getClass());
    }

    public Car(String brand, String company, Double salar) {
        this.brand = brand;
        this.company = company;
        this.salar = salar;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getSalar() {
        return salar;
    }

    public void setSalar(Double salar) {
        this.salar = salar;
    }
}
