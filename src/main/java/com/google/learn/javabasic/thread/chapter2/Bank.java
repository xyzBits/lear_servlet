package com.google.learn.javabasic.thread.chapter2;

public class Bank {
    public static void main(String[] args) {
        Thread ticketWindow1 = new TicketWindow("==1==");
        ticketWindow1.start();

        Thread ticketWindow2 = new TicketWindow("==2==");
        ticketWindow2.start();

        Thread ticketWindow3 = new TicketWindow("==3==");
        ticketWindow3.start();
    }
}
