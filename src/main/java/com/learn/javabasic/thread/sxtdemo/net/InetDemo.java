package com.learn.javabasic.thread.sxtdemo.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetDemo {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr);

        System.out.println("===========");

        addr = InetAddress.getByName("www.163.com");
        System.out.println(" 163 的网址为 " + addr.getHostAddress() + " " + addr.getHostName());


        addr = InetAddress.getByName("183.236.54.93");
        System.out.println(" 183.236.54.93 " + addr.getHostAddress() + " " + addr.getHostName());
    }
}
