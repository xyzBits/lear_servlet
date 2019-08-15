package com.google.learn.javabasic.pattern.createpattern.factory.simple;

/**
 * 如果 要加新车，就要修改这个类
 * 不符合开闭原则 ，开闭原则 是，不修改旧的类，添加新的类
 *
 * 也叫静态工厂模式，就是工厂类一般使用静态方法，
 * 通过接收的参数不同返回的对象实例
 *
 * 对于新增加的产品，无能为力，不修改代码的话，是无法扩展的
 */
public class CarFactory {

    public static ICar createCar(String type) {
        if ("奥迪".equals(type)) {
            return new Audi();
        } else if ("比亚迪".equals(type)) {
            return new Byd();
        } else {
            return null;
        }
    }
}
