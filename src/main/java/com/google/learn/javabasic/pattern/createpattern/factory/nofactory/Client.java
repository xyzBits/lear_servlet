package com.google.learn.javabasic.pattern.createpattern.factory.nofactory;

/**
 * 没有工厂模式的情况
 * 客户端要知道接口，还要知道实现，创建如果很复杂 ，还要传很多参数
 * 跟小工作坊一样，你什么都要会
 */
public class Client {
    public static void main(String[] args) {
        // 创建类交给客户来做，没有细分出这个类的创建
        ICar car = new Audi();
        ICar car1 = new Byd();
        car.run();
        car1.run();
    }
}
