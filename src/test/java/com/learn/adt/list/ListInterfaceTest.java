package com.learn.adt.list;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ListInterfaceTest {
    @Test
    public void test001() {
        ListInterface<Integer> list = new ArrList<>(30);
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(Arrays.toString(list.toArray()));
        list.add(0, 8);
        list.add(4, 9);
        System.out.println(Arrays.toString(list.toArray()));
        list.remove(3);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.contains(9));

    }

}