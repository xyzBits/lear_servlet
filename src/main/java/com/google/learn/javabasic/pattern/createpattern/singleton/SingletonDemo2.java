package com.google.learn.javabasic.pattern.createpattern.singleton;

/**
 * 懒汉模式
 */
public class SingletonDemo2 {
    // 类初始化时，不初始化这个对象，延时加载，真正用的时候再创建
    private static SingletonDemo2 instance;

    private SingletonDemo2() { //私有化构造器

    }

    //  方法同步，调用效率高
    public static synchronized SingletonDemo2 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo2();
        }
        return instance;
    }
}
