package com.learn.adt.tree.bst;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class AVLMapTest {
    private Random random = new Random();
    private final int MAX1 = 16;

    @Test
    public void testAVLPut() {
        AVLMap<Integer, String> map = new AVLMap<>();
        for (int i = 0; i < MAX1; i++) {
            map.put(random.nextInt(MAX1), random.nextInt(MAX1) + "");
        }


        Iterator<AVLEntry<Integer, String>> itr = map.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next().getKey() + " ");
        }
        System.out.println();
    }

    private final int MAX2 = 65535;

    @Test
    public void testPutWithJdk() {
        AVLMap<Integer, String> map1 = new AVLMap<>();
        TreeMap<Integer, String> map2 = new TreeMap<>();

        for (int i = 0; i < MAX2; i++) {
            int key = random.nextInt(MAX2);
            String value = random.nextInt(MAX2) + "";
            map1.put(key, value);
            map2.put(key, value);
        }

        Assert.assertEquals(map1.size(), map2.size());
        Iterator<AVLEntry<Integer, String>> itr1 = map1.iterator();
        Iterator<Map.Entry<Integer, String>> itr2 = map2.entrySet().iterator();

        while (itr1.hasNext() && itr2.hasNext()) {
            Assert.assertEquals(itr1.next().getKey(), itr2.next().getKey());
        }

        Assert.assertTrue(!itr1.hasNext() && !itr2.hasNext());
    }

    @Test
    public void testQuery() {
        AVLMap<Integer, String> map = new AVLMap<>();
        map.put(4, "a");
        map.put(2, "b");
        map.put(6, "c");
        map.put(2, "d");
        map.put(1, "a");
        map.put(3, "d");
        map.put(5, "e");
        map.put(1, "f");

        Assert.assertTrue(map.get(4).equals("a"));
        Assert.assertTrue(map.get(1).equals("f"));
        Assert.assertTrue(map.get(7) == null);

        Assert.assertTrue(map.containsKey(6));
        Assert.assertTrue(!map.containsKey(-1));
        Assert.assertTrue(map.containsValue("d"));
        Assert.assertTrue(!map.containsValue("xxxxx"));
    }

    @Test
    public void testQueryWithJdk() {
        AVLMap<Integer, String> map1 = new AVLMap<>();
        TreeMap<Integer, String> map2 = new TreeMap<>();

        for (int i = 0; i < MAX2; i++) {
            int key = random.nextInt(MAX2);
            String value = random.nextInt(MAX2) + " ";
            map1.put(key, value);
            map2.put(key, value);
        }

        for (int i = 0; i < MAX2; i++) {
            int key = random.nextInt(MAX2);
            Assert.assertTrue(map1.containsKey(key) == map2.containsKey(key));
            if (map1.get(key) == null) {
                Assert.assertNull(map2.get(key));
            } else {
                Assert.assertTrue(map1.get(key).equals(map2.get(key)));
            }
        }

        for (int i = 0; i < 500; i++) {
            String value = random.nextInt(MAX2) + " ";
            Assert.assertTrue(map1.containsValue(value) == map2.containsValue(value));
        }
    }

    @Test
    public void testRemoveCase1() {
        AVLMap<Integer, String> map = new AVLMap<>();
        int[] array = {5, 2, 6, 1, 4, 7, 3};
        for (int key : array) {
            map.put(key, key + " ");
        }

        System.out.println(map.remove(1));
        map.levelOrder();

        Iterator<AVLEntry<Integer, String>> itr = map.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next().getKey() + " ");
        }
        System.out.println();
    }


    @Test
    public void testRemoveCase2() {
        AVLMap<Integer, String> map = new AVLMap<>();
        int[] array = {5, 2, 6, 1, 4, 7, 3};
        for (int key : array) {
            map.put(key, key + " ");
        }

        System.out.println(map.remove(4));

        map.levelOrder();

        Iterator<AVLEntry<Integer, String>> itr = map.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next().getKey() + " ");
        }
        System.out.println();
    }


    @Test
    public void testRemoveCase4() {
        AVLMap<Integer, String> map = new AVLMap<>();
        int[] array = {6, 2, 7, 1, 4, 8, 3, 5};
        for (int key : array) {
            map.put(key, key + " ");
        }

        System.out.println(map.remove(2));

        map.levelOrder();

        Iterator<AVLEntry<Integer, String>> itr = map.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next().getKey() + " ");
        }
        System.out.println();
    }

    @Test
    public void testRemoveWithJdk() {
        AVLMap<Integer, String> map1 = new AVLMap<>();
        TreeMap<Integer, String> map2 = new TreeMap<>();

        for (int i = 0; i < MAX2; i++) {
            int key = random.nextInt(MAX2);
            String value = random.nextInt(MAX2) + "  ";
            map1.put(key, value);
            map2.put(key, value);
        }

        System.out.println(map1.size());

        for (int i = 0; i < MAX2 >>> 1; i++) {
            int key = random.nextInt(MAX2);
            if (map1.containsKey(key)) {
                Assert.assertTrue(map1.remove(key).equals(map2.remove(key)));
            } else {
                Assert.assertTrue(map1.remove(key) == null && map2.remove(key) == null);
            }
        }

        System.out.println(map1.size());
        Assert.assertEquals(map1.size(), map2.size());

        Iterator<AVLEntry<Integer, String>> itr1 = map1.iterator();
        Iterator<Map.Entry<Integer, String>> itr2 = map2.entrySet().iterator();

        while (itr1.hasNext() && itr2.hasNext()) {
            Assert.assertEquals(itr1.next().getKey(), itr2.next().getKey());
        }
    }

    @Test
    public void testPerson() {
        AVLMap<Person, String> map = new AVLMap<>((p1, p2) -> {
            return -p1.getId() + p2.getId();
        });
        for (int i = 0; i < MAX1; i++) {
            map.put(new Person(random.nextInt(MAX1), "name " + random.nextInt(MAX1)) , random.nextInt(MAX1) + "");
        }

        Iterator<AVLEntry<Person, String>> itr = map.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next().getKey() + " ");
        }
    }
}