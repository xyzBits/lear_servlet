package com.learn.javabasic.javadoc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class BasicType {

    @Test
    public void test002() {
        char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd'};
        char[] copyTo = new char[7];

        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
        System.out.println(new String(copyTo));
    }

    @Test
    public void test001() {
        char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd'};
        char[] copyTo = new char[7];

        System.arraycopy(copyFrom, 2, copyFrom, 0, 7);
        System.out.println(new String(copyTo));
    }

    @Test
    public void test003() {
        char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd'};
        char[] copyTo = Arrays.copyOfRange(copyFrom, 2, 9);
        Stream.of(copyTo).forEach(System.out::print);
    }

    @Test
    public void test004() {
        int i = 3;
        System.out.println(++i);
        System.out.println(i);
    }

    @Test
    public void test005() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");

        List<String> list1 = new LinkedList<>();
        list1.add("hello");
//        boolean b = list.removeAll(list1);
//        list.stream().forEach(System.out::println);
        list.retainAll(list1);
        list.stream().forEach(System.out::println);

        list.add("hello");
        list.add("hello");
        list.add("hello");
        list.add("hello");
        String[] strings = list.toArray(new String[0]);
        System.out.println(Arrays.toString(strings));
    }

    @Test
    public void test006() {
        Object[] nums = new Double[10];
        System.out.println(nums.getClass());
        nums[0] = 1;
        System.out.println(nums[0]);
    }

    @Test
    public void test007() {
        List<Integer> list = new ArrayList<>();
        System.out.println(list.getClass());
        list = new LinkedList<>();
        System.out.println(list.getClass());

        List<Integer>[] lists = (List<Integer>[]) new ArrayList[10];
        lists[0] = new ArrayList<>();
    }
}
