package com.learn.javabasic.thread.chapter1;

public class ViewThread {
    public static void main(String[] args) {
        /*new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10_000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1_000L);
                    System.out.println(1 / 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1_000L);
                    System.out.println(1 / 0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }
}
