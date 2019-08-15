package com.learn.javabasic.pattern.createpattern.factory.abstract_;

public class Client {
    public static void main(String[] args) {

        /**
         * 简单工厂，某种程度上不符合设计原则 ，但是使用最多
         *
         * 工厂方法 不修改已有类的前提下，通过增加新的工厂类实现扩展
         *
         * 抽象工厂 不可以增加产品，可以增加产品族
         *
         * @see java.util.Calendar.getInstance()
         * @see java.util.sql.Connection()
         * @see org.springframework.beans.factory.BeanFactory
         * @see Class.newInstance();
         */
    }
}
