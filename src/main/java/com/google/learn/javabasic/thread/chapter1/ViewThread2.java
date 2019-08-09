package com.google.learn.javabasic.thread.chapter1;

public class ViewThread2 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(Thread.currentThread().getName() + " i = " + i);
                }
            }
        });



        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + " i = " + i);
        }

        t.start();


        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.start();
    }
}
