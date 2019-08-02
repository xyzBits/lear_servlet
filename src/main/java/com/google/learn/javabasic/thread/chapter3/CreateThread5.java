package com.google.learn.javabasic.thread.chapter3;

public class CreateThread5 {
    private static int counter = 1;

    public static void main(String[] args) {
        try {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            //byte[] data = new byte[1024 * 1024 * 4];
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        } catch (Error e) {
            e.printStackTrace();
        } finally {
            System.out.println(counter);
        }


    }
}
