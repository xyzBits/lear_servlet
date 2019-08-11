package com.google.learn.javabasic.thread.sxtdemo.reflect.demo;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;

public class Demo6 {
    private static void test01() {
        User user = new User();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10_000_000_000L; i++) {
            user.getUname();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("普通方法调用，执行10亿次，耗时： " + (endTime - startTime) / 1000.);
    }

    private static void test02() throws Exception {
        User user = new User();
        Class clazz = user.getClass();
        Method method = clazz.getDeclaredMethod("getUname", null);
        //method.setAccessible(true);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10_000_000_000L; i++) {
            method.invoke(user, null);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("反射动态方法调用，执行10亿次，耗时： " + (endTime - startTime) / 1000.);
    }

    private static void test03() throws Exception {
        User user = new User();
        Class clazz = user.getClass();
        Method method = clazz.getDeclaredMethod("getUname", null);
        method.setAccessible(true); // 不需要安全检查 ，效率提高四倍

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10_000_000_000L; i++) {
            method.invoke(user, null);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("反射动态方法调用，跳过安全检查 ，执行10亿次，耗时： " + (endTime - startTime) / 1000.);
    }

    public static void main(String[] args) throws Exception {
        test01();
        test02();
        test02();
    }
}
