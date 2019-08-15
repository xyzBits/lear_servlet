package com.learn.javabasic.thread.sxtdemo.reflect.demo;



import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 应用反射的api 获取类的信息 名字 属性 方法构造器
 */
public class Demo2 {
    public static void main(String[] args) {
        String path = "com.google.learn.javabasic.thread.sxtdemo.reflect.demo.User";

        try {
            Class clazz = Class.forName(path);

            // 获取类的名字
            System.out.println(clazz.getName());
            System.out.println(clazz.getSimpleName());

            // 获取属性信息
            Field[] fields = clazz.getFields(); // 只能获得public field
            System.out.println(fields.length);

            fields = clazz.getDeclaredFields(); //获得所有的属性
            System.out.println(fields.length);
            System.out.println(Arrays.deepToString(fields));

            Field f = clazz.getDeclaredField("uname");
            System.out.println(f.getName());


            System.out.println("================");
            // 获取方法信息
            Method[] methods = clazz.getDeclaredMethods(); //所有声明的方法
            System.out.println(Arrays.deepToString(methods));

            methods = clazz.getMethods(); // 包含父类的方法
            System.out.println(Arrays.deepToString(methods)); //

            Method method = clazz.getMethod("getUname",null);
            System.out.println(method);
            method = clazz.getMethod("setUname", String.class); // 可能 有重载，所以传入参数类型对应的Class对象
            System.out.println(method);

            System.out.println("-----------------");
            // 获得构造器
            Constructor[] constructors = clazz.getDeclaredConstructors();
            System.out.println(Arrays.deepToString(constructors));

            constructors = clazz.getDeclaredConstructors();
            System.out.println(Arrays.deepToString(constructors));

            Constructor constructor = clazz.getDeclaredConstructor(null);
            System.out.println(constructor);


           constructor = clazz.getDeclaredConstructor(int.class, int.class, String.class);
            System.out.println(constructor);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
