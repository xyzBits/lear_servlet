package com.learn.javabasic.pattern.createpattern.factory.method;

public class BenzFactory implements ICarFactory {
    @Override
    public ICar createCar() {
        return new Benz();
    }
}
