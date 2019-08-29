package com.learn.adt.algorithm.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = getIndexOfSmallest(arr, i, arr.length - 1);
            swap(arr, i, minIndex);
        }
    }


    private static int getIndexOfSmallest(int[] arr, int first, int last) {
        int min = arr[first];
        int minIndex = first;
        for (int i = first + 1; i <= last; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
