package com.google.learn.javabasic.pattern.createpattern.factory.method;

public class BydFactory implements ICarFactory {
    @Override
    public ICar createCar() {
        return new Byd();
    }
}
