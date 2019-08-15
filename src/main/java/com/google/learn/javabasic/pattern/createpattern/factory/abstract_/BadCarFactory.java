package com.google.learn.javabasic.pattern.createpattern.factory.abstract_;

public class BadCarFactory implements ICarFactory {
    @Override
    public IEngine createEngine() {
        return new BadEngine();
    }

    @Override
    public ISeat createSeat() {
        return new BadSeat();
    }

    @Override
    public ITyre createTyre() {
        return new BadTyre();
    }
}
