package com.exercise.leetcode.april;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void testTwoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expectedResult = {0, 1};
        Assert.assertArrayEquals(expectedResult, Solution.twoSum(nums, target));
    }

    @Test
    public void testOneHashTable() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expectedResult = {0, 1};
        Assert.assertArrayEquals(expectedResult, Solution.onceHashTable(nums, target));
    }

    @Test
    public void testReverse() {
        Assert.assertEquals(-321, Solution.reverse(-123));
        Assert.assertEquals(2147483647, Solution.reverse(2147483647));
        //TwoSumSolution.reverse(123);
        //System.out.println(((int) Math.pow(2, 31)) > ((int) Math.pow(2, 31) - 1));
    }

    @Test
    public void testSortedSquares() {
        int[] A = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(com.google.learn.leetcode.array.easy.Solution.sortedSquares(A)));
        int[] B = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(com.google.learn.leetcode.array.easy.Solution.sortedSquares(B)));
        Stack<Integer> stack = new Stack<>();

    }

    @Test
    public void tet009() throws Exception {
        int[] arr = {1, 2, 3, 4};
        System.out.println(arr.getClass());
        Object[] objArr = new Object[3];
        System.out.println(objArr.getClass());
        objArr.getClass().newInstance();
    }

    @Test
    public void test010() {
        int[][] arr = new int[10][];

    }


}

class Example {
    int num1 = num2 + 1;
    static int num2;


}