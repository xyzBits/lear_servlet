package com.learn.javabasic.thread.chapter1;

public class RunnableTicketWindow implements Runnable {

    private static final int MAX = 50;

    private int index = 0;

    @Override
    public void run() {
        while (index < MAX) {
            System.out.println(Thread.currentThread() + " index = " + (index++));

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        /*Runnable runnable = new RunnableTicketWindow();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
        t4.start();*/

        Thread t = new Thread();
        t.setName("test thread");
        t.start();
        System.out.println(t.getName());

    }
}
