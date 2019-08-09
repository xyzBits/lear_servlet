package com.google.learn.javabasic.thread.chapter2;

public class TicketWindowRunnable implements Runnable {
    private int index = 0;

    private final static int MAX = 500;


    @Override
    public void run() {
/*        synchronized (this) {
            while (index < MAX) {
                System.out.println(Thread.currentThread() + " number is " + index++);
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }*/
        fun();
    }

    private synchronized void fun() {
        while (index < MAX) {
            System.out.println(Thread.currentThread() + " number is " + index++);
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
