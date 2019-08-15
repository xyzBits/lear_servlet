package com.learn.javabasic.thread.sxtdemo.reflect.demo;


import java.lang.invoke.MethodHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/**
 * 通过反射api动态操作属性 方法 构造器
 */
//@SuppressWarnings(value = {"all"})
public class Demo3 {
    public static void main(String[] args) {
        String path = "com.google.learn.javabasic.thread.sxtdemo.reflect.demo.User";

        Class clazz = null;
        try {

            clazz = Class.forName(path);
            // 通过反射api调用构造方法，创建对象
            User user1 = (User) clazz.newInstance(); // 调用构造器，如果 没有构造器，会报错
            System.out.println(user1);

            System.out.println("指定构造器来构造 ");
            Constructor<User> constructor = clazz.getConstructor(int.class, int.class, String.class);
            User usr2 = constructor.newInstance(1001, 18, "dongfangy");
            System.out.println(usr2.getUname());


            // 调用方法
            User user3 = (User) clazz.newInstance();
            Method method = clazz.getDeclaredMethod("setUname", String.class);
            method.invoke(user3, "lihui");
            System.out.println(user3.getUname());


            // 操作属性
            System.out.println("操作属性");
            Field f = clazz.getDeclaredField("uname");
            f.setAccessible(true); // 属性不用做安全检查
            f.set(user3, "hahah"); // 通过反射设置属性
            System.out.println(user3.getUname());
            System.out.println(f.get(user3)); // 通过反射读私有属性


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
