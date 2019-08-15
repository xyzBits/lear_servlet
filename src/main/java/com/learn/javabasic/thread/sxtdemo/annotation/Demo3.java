package com.learn.javabasic.thread.sxtdemo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射读取注解有信息，模拟 处理 注解的流程
 */
public class Demo3 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.google.learn.javabasic.thread.sxtdemo.annotation.SxtStudent");

            // 获得类的所有有效注解
            Annotation[] annotations = clazz.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }

            // 获得指定的注解
            SxtTable sxtTable = (SxtTable) clazz.getAnnotation(SxtTable.class);
            System.out.println(sxtTable.value());

            // 获得类的属性的注解
           Field nameField =  clazz.getDeclaredField("studentName");
           SxtField sxtField =  nameField.getAnnotation(SxtField.class);
           System.out.println(sxtField.columnName());
           System.out.println(sxtField.length());
           System.out.println(sxtField.type());

           //根据获得的表名，字段信息，拼出sql ddl语句，使用jdbc执行sql，在数据 库中生成相关的表

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
