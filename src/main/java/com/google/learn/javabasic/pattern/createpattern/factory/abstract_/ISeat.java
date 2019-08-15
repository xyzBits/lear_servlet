package com.google.learn.javabasic.pattern.createpattern.factory.abstract_;

public interface ISeat {
    void massage();

}

class GoodSeat implements ISeat {

    @Override
    public void massage() {
        System.out.println("可以自动按摩");
    }
}


class BadSeat implements ISeat {

    @Override
    public void massage() {
        System.out.println("不能按摩");
    }
}