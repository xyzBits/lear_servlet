package com.google.learn.javabasic.pattern.createpattern.factory.abstract_;

public interface ITyre {
    void revolve();
}

class GoodTyre implements ITyre {

    @Override
    public void revolve() {
        System.out.println("旋转不磨损");
    }
}


class BadTyre implements ITyre {

    @Override
    public void revolve() {
        System.out.println("旋转磨损快");

    }
}