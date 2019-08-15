package com.learn.javabasic.thread.sxtdemo;

import java.util.concurrent.TimeUnit;

public class JoinDemo implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("join ...." + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new JoinDemo());
        thread.start();

        for (int i = 0; i < 100; i++) {
            if (i == 50) {
                System.out.println("i == 50 join a thread");
                // main线程阻塞了，等thread做完所有工作 后，main才继续工作，比如thread读文件，读完后，我们的main才处理
                thread.join();
            }
            TimeUnit.MILLISECONDS.sleep(20);
            System.out.println("main ...." + i);
        }
    }
}
