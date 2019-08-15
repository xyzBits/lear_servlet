package com.google.learn.javabasic.pattern.createpattern.factory.method;

/**
 * 工厂方法
 *
 * 为了避免简单工厂模式的缺点，不完全满足ocp
 * 工厂方法模式和简单工厂模式最大的不同在于，简单工厂只有一个工厂类，而工厂方法模式
 * 有一组实现了相同接口的工厂类
 */
public class Client {
    public static void main(String[] args) {
        // 客户端编程更加复杂
        ICar audi = new AudiFactory().createCar();
        ICar byd = new BydFactory().createCar();

        // 加了新的产品后，进行扩展就行了
        // 客户端 只要与工厂打交道就行了
        ICar benz = new BenzFactory().createCar();
    }
}
