package com.google.learn.adt.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackInterfaceTest {
    @Test
    public void test001() {
        StackInterface<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        while (!stack.isEmpty() && stack.peek() != null) {
            System.out.println(stack.pop());

        }

    }


    @Test
    public void test002() {
        StackInterface<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }


    @Test
    public void test003() {
        StackInterface<Integer> stack = new VectorStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        if (!stack.isEmpty() && stack.peek() != null) {
            System.out.println(stack.pop());
        }
    }

}