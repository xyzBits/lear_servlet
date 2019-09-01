package com.learn.adt.algorithm.search;

public class LinearSearch {
    public static void main(String[] args) {

    }

    private static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
