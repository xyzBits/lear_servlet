package com.google.learn.javabasic.thread.sxtdemo.net;

import java.net.InetSocketAddress;

public class InetSocketDemo {
    public static void main(String[] args) {
        InetSocketAddress address = new InetSocketAddress("localhost", 9999);
        System.out.println(address.getHostName());
        System.out.println(address.getPort());
        System.out.println(address.getAddress());
    }
}
