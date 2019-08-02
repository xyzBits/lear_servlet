package com.google.learn.thread.basic.chapter3;

import java.util.Arrays;

public class CreateThread2 {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        System.out.println(t1.getThreadGroup());
        System.out.println(Thread.currentThread());
        System.out.println(Thread.currentThread().getThreadGroup());
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.activeCount());

        System.out.println("=============");
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        System.out.println(Arrays.toString(threads));

        Arrays.asList(threads).forEach(System.out::println);
        System.out.println(threads[1].isDaemon());
    }
}
