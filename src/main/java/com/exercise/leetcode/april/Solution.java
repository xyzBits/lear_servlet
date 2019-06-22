package com.exercise.leetcode.april;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == (target - nums[i])) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static int[] onceHashTable(int[] nums, int target) {
        Map<Integer, Integer> tempMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            tempMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (tempMap.containsKey(complement) && tempMap.get(complement) != i) {
                return new int[]{i, tempMap.get(complement)};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static long reverse(long x) {
        if (x < (long) (-Math.pow(2, 31)) / 10 || x > (long) (Math.pow(2, 31) - 1) / 10) {
            return 0;
        } else if (x >= 0) {
            return abs(x);
        } else {
            return -abs(-x);
        }

    }

    private static long abs(long x) {
        List<Long> nums = new LinkedList<>();
        long result = 0;
        while (x != 0) {
            //System.out.print(x % 10);
            nums.add(x % 10);
            x /= 10;
        }

        for (int i = 0; i < nums.size(); i++) {
            result += nums.get(i) * Math.pow(10, nums.size() - i - 1);
        }
        return result;
    }
}
