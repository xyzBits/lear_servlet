package com.java8.chapter16;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * lanbda表达式使用举例
 */
public class LambdaDemoTest {
    @Test
    public void test001() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京开安门");
            }
        };
        r1.run();


        System.out.println("************************");

        Runnable r2 = () -> System.out.println("我爱北京开安门");
        r2.run();
    }

}