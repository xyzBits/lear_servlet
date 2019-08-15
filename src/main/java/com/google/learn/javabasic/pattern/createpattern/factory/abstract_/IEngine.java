package com.google.learn.javabasic.pattern.createpattern.factory.abstract_;

public interface IEngine {
    void run();

    void start();
}

class GoodEngine implements IEngine {

    @Override
    public void run() {
        System.out.println("转的快");
    }

    @Override
    public void start() {
        System.out.println("启动快");
    }
}


class BadEngine implements IEngine {

    @Override
    public void run() {
        System.out.println("转的慢");
    }

    @Override
    public void start() {
        System.out.println("启动慢");
    }
}
