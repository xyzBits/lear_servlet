package com.google.learn.javabasic.thread.chapter2;

public class TicketWindow extends Thread {
    private final static int MAX = 500;

    private static int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    private final String name;



    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("window is " + this.name + " Current number is " + index++);
        }
    }

}
