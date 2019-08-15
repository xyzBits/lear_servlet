/*
package com.exercise.leetcode.april;

import com.learn.leetcode.array.easy.Solution;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SolutionTest {

    @Test
    public void testTwoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expectedResult = {0, 1};
        //Assert.assertArrayEquals(expectedResult, Solution.twoSum(nums, target));
    }

    @Test
    public void testOneHashTable() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expectedResult = {0, 1};
        //Assert.assertArrayEquals(expectedResult, Solution.onceHashTable(nums, target));
    }

    @Test
    public void testReverse() {
        //Assert.assertEquals(-321, Solution.reverse(-123));
        Assert.assertEquals(2147483647, Solution.reverse(2147483647));
        //TwoSumSolution.reverse(123);
        //System.out.println(((int) Math.pow(2, 31)) > ((int) Math.pow(2, 31) - 1));
    }

    @Test
    public void testSortedSquares() {
*/
/*        int[] A = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(com.google.learn.leetcode.array.easy.Solution.sortedSquares(A)));
        int[] B = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(com.google.learn.leetcode.array.easy.Solution.sortedSquares(B)));
        Stack<Integer> stack = new Stack<>();*//*


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
        System.out.println(arr.getClass().getPackage());
        List<Integer> list = new ArrayList<>();
        System.out.println(list.getClass().getPackage());
        System.out.println(list.getClass().getName());
        System.out.println(list.getClass().getSuperclass());
        System.out.println(Arrays.toString(list.getClass().getInterfaces()));
        System.out.println(List.class);
        System.out.println("==============");
        System.out.println(Arrays.toString(list.getClass().getMethods()));
        System.out.println(Arrays.toString(list.getClass().getDeclaredMethods()));
        List<Method> methods = Arrays.asList(list.getClass().getMethods());
        List<Method> declaredMethods = Arrays.asList(list.getClass().getDeclaredMethods());
        //methods.removeAll(declaredMethods);
        System.out.println(methods);


    }

    @Test
    public void test011() throws Exception {
        List<Integer> list = new ArrayList<>();
        Class clazz = list.getClass();
        Class[] classes = clazz.getDeclaredClasses();
        System.out.println(Arrays.toString(classes));
        Field[] fields = clazz.getFields();
        System.out.println("fields = " + Arrays.toString(fields));

        Field[] decFields = clazz.getDeclaredFields();
        System.out.println("decFields = " + Arrays.toString(decFields).replace("java.util.ArrayList", ""));

        Constructor[] publicCons = clazz.getConstructors();
        System.out.println(Arrays.toString(publicCons));
        Constructor[] decCons = clazz.getDeclaredConstructors();
        System.out.println(Arrays.toString(decCons));
        System.out.println(1400 * 4);

    }

    @Test
    public void test012() {
        Class clazz = ArrayList.class;
        clazz = LinkedList.class;

        Class<?> intClass = Integer.class;
        intClass = Number.class;
        System.out.println(void.class);
        System.out.println(int.class);
        System.out.println(float.class + " " + char.class);

    }

    @Test
    public void test013() throws Exception {
        Class clazz = ArrayList.class;
        Method[] methods = clazz.getMethods();
        System.out.println(Arrays.toString(methods));
        Object object = clazz.newInstance();
        ArrayList<Integer> list = (ArrayList) object;
        list.add(1);
        System.out.println(list.get(0));

    }

    @Test
    public void test014() {
        String str = "hello world";
        int index = str.indexOf("z");
        System.out.println(index);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int num = Integer.parseInt(str);
        System.out.println(num);
    }

    @Test
    public void test015() {
        Throwable ex = new Throwable("Null pointer", new NullPointerException());
        System.out.println(ex.getMessage());
        System.out.println(ex.getCause());
        System.out.println();
    }


}

class Example {
    int num1 = num2 + 1;
    static int num2;


}*/
