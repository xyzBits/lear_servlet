package com.learn.javabasic.thread.Chapter7;


public class SynchronizedRunnable implements Runnable {
    private int index = 0;

    private final static int MAX = 500;

    // 只有一个线程工作
    @Override
    public void run() {
      /*  while (index < MAX) {
            System.out.println(Thread.currentThread() + " number is " + index++);
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        while (true) {
            if (ticke()) {
                break;
            }
        }
    }

    private synchronized boolean ticke() {
        if (index > MAX) {
            return true;
        }

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread() + " index ==" + index++);
        return false;
    }
}
