package com.google.learn.thread.basic.chapter2;

public class BankVersion2 {
    public static void main(String[] args) {
        final TicketWindowRunnable ticketWindow = new TicketWindowRunnable();
        Thread windowThread1 = new Thread(ticketWindow, "==1==");
        Thread windowThread2 = new Thread(ticketWindow, "==2==");
        Thread windowThread3 = new Thread(ticketWindow, "==3==");
        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
    }
}
