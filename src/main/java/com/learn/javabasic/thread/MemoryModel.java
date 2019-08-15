package com.learn.javabasic.thread;

public class MemoryModel {
    private static boolean iniFlag = false;


    public static void main(String[] args) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("wait to prepare data");
                while (!iniFlag) {

                }
                System.out.println("prepare data succeed");
            }
        }).start();

        Thread.sleep(4000L);
        new Thread(new Runnable() {
            @Override
            public void run() {
                prepare();
            }
        }).start();
    }

    private static void prepare() {
        System.out.println("prepare data ");
        iniFlag = true;
        System.out.println("end prepare data");
    }
}
