package com.learn.javabasic.thread.sxtdemo;

/**
 * 票数是固定的，方便共享资源
 *
 */
public class Web12306 implements Runnable {
    private int num = 50;


    @Override
    public void run() {
        while (true) {
            if (num <= 0) {
                break; // 跳出循环
            }
            System.out.println(Thread.currentThread().getName() + " 抢到了 ====> " + (num--));
        }
    }

    public static void main(String[] args) {
        // 这个就是资源， 让三个代理去操作这个资源
        Web12306 web = new Web12306();
        Thread t1 = new Thread(web, "路人甲");
        Thread t2 = new Thread(web, "黄牛乙");
        Thread t3 = new Thread(web, "攻城狮");
        t1.start();
        t2.start();
        t3.start();
    }
}
