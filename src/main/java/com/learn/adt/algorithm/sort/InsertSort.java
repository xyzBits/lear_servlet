package com.learn.adt.algorithm.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 8, 7, 6,6 ,5, 4, 3, 2, 1, 0};
        System.out.println(Arrays.toString(arr));

/*        arr = new int[800000];
        for (int i = 0; i < 800000; i++) {
            arr[i] = (int) (Math.random() * 80000000); // 生成一个[0, 8000000) 数
        }*/
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 从第二个元素开始向前插入
            // 一直插到第0个位置
            for (int j = i; j >= 1; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
            System.out.println(Arrays.toString(arr));

        }
    }

    private static void insertSort1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            for (int j = i; j > 0 && (arr[j] < arr[j - 1]); j--) {

                swap(arr, j, j - 1);

            }
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
