package com.learn.javabasic.pattern.createpattern.factory.method;

public class AudiFactory implements ICarFactory {
    @Override
    public ICar createCar() {
        return new Audi();
    }
}
