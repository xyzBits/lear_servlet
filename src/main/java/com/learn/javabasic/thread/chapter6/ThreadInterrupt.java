package com.learn.javabasic.thread.chapter6;

public class ThreadInterrupt {
    private static final Object MONITOR = new Object();

    public static void main(String[] args) {
        /*Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    *//*try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("shoudao interrupted single ");
                        e.printStackTrace();
                    }*//*

                    synchronized (MONITOR) {
                        try {
                            MONITOR.wait(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        t.start();
        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.isInterrupted());
        t.stop();*/

        /*Thread t = new Thread(() -> {
            synchronized (MONITOR) {
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });*/

        Thread t = new Thread(() -> {
            while (true) {

            }
        });

        t.start();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.currentThread().interrupt();
                System.out.println("interrupt t");
            }
        };
        t1.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
