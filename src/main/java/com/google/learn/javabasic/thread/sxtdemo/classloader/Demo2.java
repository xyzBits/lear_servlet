package com.google.learn.javabasic.thread.sxtdemo.classloader;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) {
        System.out.println("当前应用的类加载器" + ClassLoader.getSystemClassLoader());
        System.out.println("当前应用的类加载器  的父类加载器 " + ClassLoader.getSystemClassLoader().getParent());

        System.out.println("当前应用的类加载器  的父类加载器  的父类加载器 " + ClassLoader.getSystemClassLoader().getParent().getParent());


        System.out.println("当前类加载路径   " + System.getProperty("java.class.path"));

        System.out.println("hello".getClass().getClassLoader());

        Cookie  cookie = new Cookie("hello", "hello");
        //System.out.println(cookie.getClass().getClassLoader());

    }
}
