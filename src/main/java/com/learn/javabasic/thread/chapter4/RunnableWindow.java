package com.learn.javabasic.thread.chapter4;

public class RunnableWindow implements Runnable {
    private int index = 1;
    private final static int MAX = 500000000;

    private final static Object MUTEX = new Object();


    @Override
    public void run() {
        synchronized (MUTEX) {
            while (index < MAX) {
                System.out.println(Thread.currentThread() + " number is " + (index++));
            }
        }
    }

    public static void main(String[] args) {
        final RunnableWindow task = new RunnableWindow();
        Thread t1 = new Thread(task, "NUM--1");
        Thread t2 = new Thread(task, "NUM--2");
        Thread t3 = new Thread(task, "NUM--3");
        Thread t4 = new Thread(task, "NUM--4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
