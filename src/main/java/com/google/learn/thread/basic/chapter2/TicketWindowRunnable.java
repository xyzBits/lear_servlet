package com.google.learn.thread.basic.chapter2;

public class TicketWindowRunnable implements Runnable {
    private int index = 0;

    private final static int MAX = 100;

    @Override
    public synchronized void run() {
        while (index < MAX) {
            System.out.println(Thread.currentThread() + " number is " + index++);
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
