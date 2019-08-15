package com.learn.javabasic.thread.sxtdemo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        Class clazz = Override.class;
        Class[] arr = clazz.getInterfaces();
        clazz.getSuperclass();
        System.out.println(Arrays.deepToString(arr));
        System.out.println(clazz.getSuperclass());

        Class anno = arr[0];
        System.out.println(anno.getSuperclass());
        test001();


    }

    public String toString() {
        return "";
    }


    @SuppressWarnings("deprecation")
    //@SuppressWarnings({"all", "unchecked"})
    private static void test001() {
        List list = new ArrayList();
        test002();
    }

    @Deprecated
    private static void test002() {

    }
}

@Target(value = {ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@interface MyAnnotation {
    String studentNam();

    String sex();

    int height();

    boolean isMan();

    String[] schools() default {"mit", "ucb"};

    Class hello() default String.class;

    int[] wiefs() default {1, 2, 3};
}

@MyAnnotation(studentNam = "hello", height = 2, isMan = true, schools = "bjsxt", sex = "man")
@interface she {

}

