package com.learn.javabasic.thread.chapter4;

public class DaemonThread2 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Thread innerThread = new Thread(() -> {
                try {
                    while (true) {
                        System.out.println("Doing heat beating");
                        Thread.sleep(10_000L);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            innerThread.setDaemon(false);
            innerThread.start();

            try {
                Thread.sleep(3_000L);
                System.out.println("T thread finished done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.setDaemon(false);
        t.start();
    }
}
