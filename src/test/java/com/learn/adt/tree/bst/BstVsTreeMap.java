package com.learn.adt.tree.bst;

import org.junit.Test;

import java.util.Random;
import java.util.TreeMap;

public class BstVsTreeMap {
    private Random random = new Random();
    private final int MAX = 20480;

    @Test
    public void testBstRandom() {
        AVLMap<Integer, String> map = new AVLMap<>();
        for (int i = 0; i < MAX; i++) {
            map.put(random.nextInt(MAX), random.nextInt(MAX) + "");
        }

        for (int i = 0; i < MAX; i++) {
            map.get(random.nextInt(MAX));
        }
    }

    @Test
    public void testTreeMapRandom() {
        TreeMap<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < MAX; i++) {
            map.put(random.nextInt(MAX), random.nextInt(MAX) + "");
        }

        for (int i = 0; i < MAX; i++) {
            map.get(random.nextInt(MAX));
        }
    }

    @Test
    public void testBstIncrement() {
        AVLMap<Integer, String> map = new AVLMap<>();
        for (int i = 0; i < MAX; i++) {
            map.put(i, random.nextInt(MAX) + "");
        }

        for (int i = 0; i < MAX; i++) {
            map.get(random.nextInt(MAX));
        }
    }

    @Test
    public void testTreeMapIncrement() {
        TreeMap<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < MAX; i++) {
            map.put(i, random.nextInt(MAX) + "");
        }

        for (int i = 0; i < MAX; i++) {
            map.get(random.nextInt(MAX));
        }
    }
}
