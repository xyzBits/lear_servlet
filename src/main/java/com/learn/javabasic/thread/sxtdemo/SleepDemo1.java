package com.learn.javabasic.thread.sxtdemo;

import java.util.concurrent.TimeUnit;

public class SleepDemo1 implements Runnable {
    private int num = 50;


    @Override
    public void run() {
        while (true) {
            if (num <= 0) {
                return; // 跳出循环 break
            }

            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 抢到了 ====> " + (num--));
        }
    }

    public static void main(String[] args) {
        //  这个就是资源， 让三个代理去操作这个资源
        SleepDemo1 web = new SleepDemo1();
        Thread t1 = new Thread(web, "路人甲");
        Thread t2 = new Thread(web, "黄牛乙");
        Thread t3 = new Thread(web, "攻城狮");
        t1.start();
        t2.start();
        t3.start();
    }

}
