package com.learn.javabasic.thread.Chapter7;


public class SynchronizedTest {
    private static final Object LOCK = new Object();
    public static void main(String[] args) {
 /*       Runnable runnable = () -> {
            synchronized (LOCK) {
                try {
                    Thread.sleep(500_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
*/


        final SynchronizedRunnable ticketWindow = new SynchronizedRunnable();
        Thread windowThread1 = new Thread(ticketWindow, "==1==");
        Thread windowThread2 = new Thread(ticketWindow, "==2==");
        Thread windowThread3 = new Thread(ticketWindow, "==3==");
        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
    }
}
