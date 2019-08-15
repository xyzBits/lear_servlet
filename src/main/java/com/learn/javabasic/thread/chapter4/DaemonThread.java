package com.learn.javabasic.thread.chapter4;

public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = Thread.currentThread();
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "  running");
                    Thread.sleep(20_0000L);
                    System.out.println(Thread.currentThread().getName() + "  done");
                    System.out.println(thread.isAlive());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.setDaemon(true);
        t.start();

        Thread.sleep(10_0000L);
        System.out.println(thread.getName());

    }
}
