package com.learn.javabasic.thread.sxtdemo;

import java.util.concurrent.TimeUnit;

public class YieldDemo implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("yield ...." + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new JoinDemo());
        thread.start();

        for (int i = 0; i < 100; i++) {
            if (i % 20 == 0) {
                System.out.println("i ==  yield main thread");
                // 写在谁的线程体里，就暂停谁
                Thread.yield();
            }
            TimeUnit.MILLISECONDS.sleep(20);
            System.out.println("main ...." + i);
        }
    }
}
