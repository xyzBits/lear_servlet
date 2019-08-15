package com.learn.adt.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueInterfaceTest {
    @Test
    public void test001() {
        QueueInterface<Integer> queue = new LinkedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }

    }

}