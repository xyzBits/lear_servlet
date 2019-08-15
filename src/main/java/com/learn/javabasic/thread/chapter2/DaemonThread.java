package com.learn.javabasic.thread.chapter2;

public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        //thread.setDaemon(true);
        thread.start();

        Thread.sleep(2_000L);
        System.out.println("main thread is dead");
    }


}
