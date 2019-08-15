package com.learn.javabasic.thread.chapter3;

public class CreateThread3 {
    private int i = 0;
    private byte[] bytes = new byte[1024];
    private static int count = 0;

    public static void main(String[] args) {
        int j = 0;
        int[] arr = new int[1024];
        Thread thread = Thread.currentThread();

        try {
            add(0);
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(count);
        }
    }

    private static void add(int i) {
        //System.out.println(i);
        count++;
        add(i + 1);
    }
}
