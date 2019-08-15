package com.learn.adt.bag;

import org.junit.Test;

import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ArrayBagTest {
    @Test
    public <T> void test1() {
        @SuppressWarnings("unchecked")
        T[] bag = (T[]) new Object[4];
    }

    @Test
    public void test2() {
        BagInterface<Integer> bag = new ArrayBag<>(11);
        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.add(1);
        bag.add(1);
        bag.add(8);
        //System.out.println(bag.add(6));
        //System.out.println(bag.getCurrentSize());
        //bag.displayBag();
//
        //bag.remove(3);
        ////System.out.println();
        //bag.displayBag();
        //bag.clear();
        //System.out.println(bag.getCurrentSize());
        //bag.displayBag();
        System.out.println(bag.getFrequencyOf(1));

        bag.displayBag();
        System.out.println(bag.getCurrentSize());
        bag.remove(1);
        bag.displayBag();
    }

    @Test
    public void test3() {
        List<String> stringList = new ArrayList<>();
        List list = new ArrayList();
        System.out.println(stringList.getClass());
        System.out.println(list.getClass());
    }

    @Test
    public void test4() {
        List<String> a = new ArrayList<>();
        a.add("csdn");
        Class c = a.getClass();

        try {
            Method method = c.getMethod("add", Object.class);
            method.invoke(a, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(a);
    }
}