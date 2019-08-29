package com.learn.adt.algorithm.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 9, 7, 10, -3, -5, 22, 8, 10, 2, 1, 0, 7, 6, 6, 5, 4, 3, 9, 13};

        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }


    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 分成两半
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            // 合并在一起
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, t = 0;
        // 1 将有序的填充到temp
        while ((i <= mid) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }

        // 2 填充剩余元素
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }

        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }

        t = 0;
        for (int k = left; k <= right; k++) {
            arr[k] = temp[t];
            t++;
        }
    }
}
