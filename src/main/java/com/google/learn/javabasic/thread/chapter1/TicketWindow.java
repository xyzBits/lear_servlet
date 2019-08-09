package com.google.learn.javabasic.thread.chapter1;

public class TicketWindow extends Thread {

    private static final int MAX = 50;
    private static int index = 0;

    @Override
    public void run() {
        while (index < MAX) {
            System.out.println(Thread.currentThread().getName() + " index = " + (index++));
        }
    }

    public static void main(String[] args) {
        TicketWindow ticketWindow1 = new TicketWindow();
        TicketWindow ticketWindow2 = new TicketWindow();

        TicketWindow ticketWindow3 = new TicketWindow();

        TicketWindow ticketWindow4 = new TicketWindow();

        ticketWindow1.start();
        ticketWindow2.start();
        ticketWindow3.start();
        ticketWindow4.start();
    }
}
