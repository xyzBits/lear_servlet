package com.learn.javabasic.pattern.createpattern.singleton;

/**
 * 饿汉单例模式
 */
public class SingletonDemo1 {

    // 类初始化时，立即加载这个对象，没有延时加载的优势，加载类时，天然的是线程安全的
    private static final SingletonDemo1 instance = new SingletonDemo1();

    private SingletonDemo1() {

    }

    // 方法没有同步，调用效率
    public static SingletonDemo1 getInstance() {
        return instance;
    }

}
