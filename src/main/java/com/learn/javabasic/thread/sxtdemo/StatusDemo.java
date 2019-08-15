package com.learn.javabasic.thread.sxtdemo;

import java.sql.Statement;

public class StatusDemo implements Runnable {
    // 1 线程类中定义线程使用的标识
    private boolean flag = true;

    @Override
    public void run() {
        // 2 线程体使用该标识
        while (flag) {
            System.out.println("Thread status ...........");
        }

    }

    // 3 对外提供方法，改变标识

    public void shutDown() {
        flag = false;
    }

    public static void main(String[] args) {
        StatusDemo s = new StatusDemo();
        Thread thread = new Thread(s);
        thread.start();
        for (int i = 0; i < 1000; i++) {
            if (i == 500) {
                s.shutDown();
            }
            System.out.println(i);
        }
    }
}
