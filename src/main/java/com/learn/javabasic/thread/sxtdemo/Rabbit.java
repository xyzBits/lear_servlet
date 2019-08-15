package com.learn.javabasic.thread.sxtdemo;

public class Rabbit extends Thread {


    @Override
    public void run() {
        // 线程体
        for (int i = 1; i <= 100; i++) {
            System.out.println("兔子跑了 " + i + " 步");
        }
    }
}


class Tortoise extends Thread {


    @Override
    public void run() {
        // 线程体
        for (int i = 1; i <= 100; i++) {
            System.out.println("乌龟跑了 " + i + " 步");
        }
    }
}