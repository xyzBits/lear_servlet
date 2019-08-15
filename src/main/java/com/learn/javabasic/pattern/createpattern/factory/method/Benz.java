package com.learn.javabasic.pattern.createpattern.factory.method;

/**
 * 如果 有新的产品加进来，加入新的类就行了
 */
public class Benz implements ICar {
    @Override
    public void run() {
        System.out.println("奔驰在跑");

    }
}
