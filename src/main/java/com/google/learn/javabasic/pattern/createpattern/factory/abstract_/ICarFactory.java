package com.google.learn.javabasic.pattern.createpattern.factory.abstract_;

public interface ICarFactory {
    IEngine createEngine();

    ISeat createSeat();

    ITyre createTyre();
}
