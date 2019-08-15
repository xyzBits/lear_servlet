package com.google.learn.javabasic.pattern.createpattern.singleton;

/**
 * 静态赔类实现单例模式
 * 这种方式，线程安全，调用效率高，并且实现了延时加载
 */
public class SingletonDemo3 {

    // 静态内部类被 使用的时候才加载，因此才成了懒加载，而又由于类加载是线程安全的，所以是线程安全的，调用效率又高
    private static class SingletonClassInstance {
        private static final SingletonDemo3 instance = new SingletonDemo3();
    }

    private SingletonDemo3() {

    }

    public static SingletonDemo3 getInstance() {
        return SingletonClassInstance.instance;
    }
}
