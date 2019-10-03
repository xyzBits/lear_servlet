package com.learn.javabasic.core;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaTest {

    @Test
    public void test001() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("ni hao ");
            }
        };
        runnable.run();

        Runnable runnable1 = () -> {
            System.out.println("ni bu hao");
        };
        runnable1.run();

        Runnable runnable2 = () -> System.out.println("ni hhhhh");
        runnable2.run();
    }

    /**
     * lambda表达式就是一个接口的对象
     */
    class MyCompactor implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
        }
    }

    @Test
    public void test002() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator.compare(1, 2));

        Comparator<Integer> comparator1 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(comparator1.compare(33, 2));

        Comparator<Integer> comparator2 = new MyCompactor();
        System.out.println(comparator2.compare(44, 33));

        Comparator<Integer> comparator3 = Integer::compare;
        System.out.println(comparator3.compare(33, 33));
        System.out.println(comparator1);
    }

    @Test
    public void test003() {
        Consumer<String> c = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        c.accept("sha bi jiu shi ni ");
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept(" ni shi sha bi ");

        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("llllllllll");
    }

    @FunctionalInterface
    interface MyInterface {
        void method1();
        /*void method2();*/
    }

    public void happyTime(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void test005() {
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("买了水， 价格为 " + aDouble);
            }
        });

        happyTime(5000, money -> System.out.println("学了labda, " + money + this));
    }


    private List<String> filter(List<String> list, Predicate<String> predicate) {
        List<String> result = new ArrayList<>();

        for (String s : list) {
            if (predicate.test(s)) {
                result.add(s);
            }
        }
        return result;
    }

    @Test
    public void test006() {
        String[] arr = {"hello", "world", "you", "are", "ok ok"};
        List<String> list = Arrays.asList(arr);
        List<String> filter = filter(list, s -> s.equalsIgnoreCase("you"));
        System.out.println(filter);
    }
}
