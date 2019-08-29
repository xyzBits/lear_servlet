package com.learn.adt.algorithm.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 9, 7, 10, -3, -5, 22, 8, 10, 2, 1, 0, 7, 6, 6, 5, 4, 3, 9, 13};
        //System.out.println(Arrays.toString(arr));
/*
        arr = new int[8000];
        for (int i = 0; i < 8000; i++) {
            arr[i] = (int) (Math.random() * 800000); // 生成一个[0, 8000000) 数
        }*/
        quick2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quick2(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }

        int i = start, j = end, pivot = arr[start];

        while (i < j) {
            while ((i < j) && (arr[j] >= pivot)) {
                j--;
            }

            while ((i < j) && (arr[i] <= pivot)) {
                i++;
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }

        swap(arr, start, i);
        quick2(arr, start, i - 1);
        quick2(arr, i + 1, end);

    }


    private static void quickSort1(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }

        int i = start, j = end, pivot = arr[start];

        while (i < j) {
            while ((i < j) && (arr[j] >= pivot)) {
                j--; //当碰到小于pivot的元素，j刚好就停在这个元素的位置
            }

            while ((i < j) && (arr[i] <= pivot)) {
                i++;//当碰到大于pivot的元素，i刚好就停在这个元素的位置
            }

            if (i < j) {
                swap(arr, i, j);//刚好把大的小的交换
            }
        }
        /**
         * 停下的位置，是j发现有一个
         * i == j
         */
        System.out.println("i = " + i + " j = " + j);

        //System.exit(1);
        swap(arr, start, i);
        quickSort1(arr, start, i - 1);
        quickSort1(arr, i + 1, end);
    }

    private static void quickSort(int[] arr, int low, int high) {
        int i, j, pivot, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        pivot = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (pivot <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (pivot >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        System.out.println("i = " + i + " j = " + j);
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = pivot;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }


    private static void qSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(arr, left, right);
        qSort(arr, left, pivotIndex - 1);
        qSort(arr, pivotIndex + 1, right);
    }


    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while ((left < right) && (arr[right] >= pivot)) {
                right--;
            }

            while ((left < right) && (arr[left] <= pivot)) {
                left++;
            }

            swap(arr, left, right);
        }
        //arr[right] = pivot;
        return right;
    }


    private static void quickSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }


    private static void sort(int[] arr, int left, int right) {

        if (left > right) {
            return;
        }

        int i = left;
        int j = right;
        int pivot = arr[i + (j - i) / 2];
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }

            while (i < j && arr[i] <= pivot) {
                i++;
            }


            if (i < j) {
                swap(arr, i, j);
            }
        }

        swap(arr, i, left);

        sort(arr, left, j - 1);
        sort(arr, j + 1, right);


    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
