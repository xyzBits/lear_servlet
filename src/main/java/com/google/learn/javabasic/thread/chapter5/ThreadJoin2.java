package com.google.learn.javabasic.thread.chapter5;

public class ThreadJoin2 {
    public static void main(String[] args) throws InterruptedException {
        /*Thread t1 = new Thread(() -> {
            for (int i = 0; i < 2_000; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "  " + i);
            }
        });

        t1.start();
        t1.join(5_000);

        System.out.println("All of tasks finish done");
        for (int i = 0; i < 1_000; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "  " + i);
        }
*/

        // http server
        Thread.currentThread().join();
    }
}
