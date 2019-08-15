package com.learn.adt.bag;

import org.junit.Test;

import java.util.Arrays;

public class ArrBagTest {
    @Test
    public void test001() {
        BagInterface<Integer> bag = new ArrBag<>(200);
        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.add(4);
        bag.add(1);
        bag.add(4);
        bag.add(1);
        bag.add(8);
        System.out.println(Arrays.toString(bag.toArray()));
        System.out.println(bag.getFrequencyOf(1));
        System.out.println(bag.contains(8));

        System.out.println("test delete -----");
        bag.clear();
        System.out.println(Arrays.toString(bag.toArray()));


    }

    @Test
    public void test002() {
        BagInterface<Integer> bag = new LinkedBag<>();
        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.add(4);
        bag.add(1);
        bag.add(4);
        bag.add(1);
        bag.add(8);
        System.out.println(Arrays.toString(bag.toArray()));

        //System.out.println(bag.getFrequencyOf(1));
        //System.out.println(bag.contains(8));

        System.out.println("test delete -----");
        bag.clear();
        System.out.println(Arrays.toString(bag.toArray()));
    }

}