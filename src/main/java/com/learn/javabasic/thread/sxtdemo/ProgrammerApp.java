package com.learn.javabasic.thread.sxtdemo;

public class ProgrammerApp {
    public static void main(String[] args) {
        Programmer programmer = new Programmer();
        Thread proxy = new Thread(programmer);
        proxy.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("一边聊QQ ----> " + i);
        }
    }
}
