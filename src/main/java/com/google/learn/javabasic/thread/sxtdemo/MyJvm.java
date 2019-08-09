package com.google.learn.javabasic.thread.sxtdemo;

public class MyJvm {
    private static MyJvm instance;

    private MyJvm() {
    }

    public static MyJvm getInstance() {
        if (instance == null) {
            synchronized (MyJvm.class) {
                if (instance == null) {
                    instance = new MyJvm();
                }
            }
        }
        return instance;
    }
}


/**
 * 饿汉式
 */
class MyJvm2 {
    private static MyJvm2 instance = new MyJvm2();

    private MyJvm2() {
    }

    public static MyJvm2 getInstance() {
        return instance;
    }
}


/**
 * 类在使用的时候加载，延迟了加载
 */
class MyJvm3 {
    private static class JvmHolder {
        private static MyJvm3 instance = new MyJvm3();
    }
    private MyJvm3() {}

    public static MyJvm3 getInstance() {
        return JvmHolder.instance;
    }
}
