package com.google.learn.javabasic.pattern.createpattern.factory.abstract_;

public class GoodCarFactory implements ICarFactory {
    @Override
    public IEngine createEngine() {
        return new GoodEngine();
    }

    @Override
    public ISeat createSeat() {
        return new GoodSeat();
    }

    @Override
    public ITyre createTyre() {
        return new GoodTyre();
    }
}
