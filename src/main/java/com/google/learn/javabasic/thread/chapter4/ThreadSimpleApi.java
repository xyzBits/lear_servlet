package com.google.learn.javabasic.thread.chapter4;

public class ThreadSimpleApi {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("hello");
            try {
                Thread.sleep(500_0000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        System.out.println(t.getName());
        System.out.println(t.getId());
        System.out.println(t.getPriority());
    }
}
