package com.learn.adt.queue;

import com.google.learn.adt.stack.EmptyStackException;

public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        super("Queue object is empty");
    }
}
