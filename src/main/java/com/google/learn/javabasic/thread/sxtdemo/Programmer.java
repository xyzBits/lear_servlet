package com.google.learn.javabasic.thread.sxtdemo;

public class Programmer implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("一边敲Hello world ----> " + i);
        }
    }
}
