package com.google.learn.javabasic.thread.chapter3;

public class CreateThread {
    public static void main(String[] args) {
        Thread t0 = new Thread();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("override run method");
            }
        };

        t0.start();
        t1.start();
        System.out.println(t0.getName());
        System.out.println(t0.getId());
        System.out.println(t1.getName());
        System.out.println(t1.getId());

        Thread t3 = new Thread("MyName");
        Thread t4 = new Thread(() -> {
            System.out.println("runnable interface");
        });
        t3.start();
        t4.start();
        System.out.println(t3.getName());
        System.out.println(t4.getName());


        Thread t5 = new Thread(() -> {
            System.out.println("runnable interface" + Thread.currentThread().getName());
        }, "Runnable thread");
        t5.start();
        System.out.println(t5.getName());
    }
}
