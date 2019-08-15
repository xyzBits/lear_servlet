package com.google.learn.javabasic.pattern.createpattern.factory.simple;

/**
 * 简单工厂模式
 */
public class Client {
    public static void main(String[] args) {
        // 创建了一个新的类，实现了新的分工，client只用就行了，有专门的类负责创建
        // 只与CarFactory打交道就行，让CarFactory与Car的创建打交道
        ICar car = CarFactory.createCar("比亚迪");
        car.run();
    }
}
