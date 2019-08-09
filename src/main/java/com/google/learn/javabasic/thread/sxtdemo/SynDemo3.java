package com.google.learn.javabasic.thread.sxtdemo;

public class SynDemo3 {
    public static void main(String[] args) {
        Object goods = new Object();
        Object money = new Object();

        Test t1 = new Test(goods, money);
        Test2 t2 = new Test2(goods, money);

        Thread proxy = new Thread(t1);
        Thread proxy2 = new Thread(t2);
        proxy.start();
        proxy2.start();
    }
}

class Test implements Runnable {

    Object goods;

    public Test(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    Object money;

    @Override
    public void run() {
        while (true) {
            test();
        }
    }

    private void test() {
        synchronized (goods) {
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (money) {

            }
        }

        System.out.println("一手给钱");
    }
}

class Test2 implements Runnable {

    Object goods;

    public Test2(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    Object money;

    @Override
    public void run() {
        while (true) {
            test();
        }
    }

    private void test() {
        synchronized (money) {
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (goods) {

            }
        }

        System.out.println("一手给货");
    }
}
