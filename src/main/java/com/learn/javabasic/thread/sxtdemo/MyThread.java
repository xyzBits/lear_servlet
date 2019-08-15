package com.learn.javabasic.thread.sxtdemo;

public class MyThread implements Runnable {
    private boolean flag = true;
    private int num = 0;


    @Override
    public void run() {
        while (flag) {
            System.out.println("num ---> " + num++);
        }
    }

    public void stop() {
        this.flag = !flag;
    }
}
