package com.google.learn.javabasic.thread.sxtdemo.net;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlDemo {
    public static void main(String[] args) throws MalformedURLException {
        // 绝对路径构建
        URL url = new URL("https://www.baidu.com:80/index.html#aa?uname=bjsxt");
        System.out.println(url);
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getFile());
        System.out.println(url.getPath());
        System.out.println(url.getRef());
        System.out.println(url.getQuery());
    }
}
