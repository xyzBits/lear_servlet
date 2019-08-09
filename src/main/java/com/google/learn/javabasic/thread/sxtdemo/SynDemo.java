package com.google.learn.javabasic.thread.sxtdemo;

import java.util.concurrent.TimeUnit;


/**
 * 多个线程访问同一份资源
 */
public class SynDemo implements Runnable {

    private static Object Mutex = new Object();
    private int num = 15050;
    private boolean flag = true;


    @Override
    public void run() {
        while (flag) {
            test3();
        }
    }

    // 锁定资源不正确，一般锁本对象
    private void test5() {
        synchronized ((Integer) num) {
            if (num <= 0) {
                flag = false; // 跳出循环 break
                return;
            }

            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 抢到了 。。。====> " + (num--));
        }
    }

    // 锁定的范围不正确
    private void test4() {
        synchronized (this) {
            if (num <= 0) {
                flag = false; // 跳出循环 break
                return;
            }
        }

        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 抢到了 。。。====> " + (num--));

    }

    private void test3() {
        synchronized (this) {
            if (num <= 0) {
                flag = false; // 跳出循环 break
                return;
            }

            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 抢到了 。。。====> " + (num--));
        }
    }

    private synchronized void test2() {
        if (num <= 0) {
            flag = false; // 跳出循环 break
            return;
        }

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 抢到了 。。。====> " + (num--));
    }


    // 线程不安全
    private void test1() {
        if (num <= 0) {
            flag = false; // 跳出循环 break
            return;
        }

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 抢到了 。。。====> " + (num--));
    }

    public static void main(String[] args) {
        //  这个就是资源， 让三个代理去操作这个资源
        SynDemo web = new SynDemo();
        Thread t1 = new Thread(web, "路人甲");
        Thread t2 = new Thread(web, "黄牛乙");
        Thread t3 = new Thread(web, "攻城狮");
        //t2.setPriority(Thread.MAX_PRIORITY);
        t2.start();
        t3.start();
        t1.start();

    }
}
