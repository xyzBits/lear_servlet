package com.learn.adt.algorithm.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 8, 7, 6,6 ,5, 4, 3, 2, 1, 0};
        System.out.println(Arrays.toString(arr));
/*
        arr = new int[8000];
        for (int i = 0; i < 8000; i++) {
            arr[i] = (int) (Math.random() * 800000); // 生成一个[0, 8000000) 数
        }*/
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * \       for (int i = 1; i < arr.length; i++) {
     *             for (int j = i; j > 0; j--) {
     *                 if (arr[j] < arr[j - 1]) {
     *                     swap(arr, j, j - 1);
     *                 }
     *             }
     *             System.out.println(Arrays.toString(arr));
     *
     *         }
     * @param arr
     */
    private static void shellSort(int[] arr) {
        int gap = arr.length / 2;

        while (gap > 0) {
            for (int i = 1; i < arr.length; i++) {

                for (int j = i; j >= gap; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        swap(arr, j, j - gap);
                    }
                }

            }
            System.out.println(Arrays.toString(arr));
            System.out.println(gap);

            gap /= 2;
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
