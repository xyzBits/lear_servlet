package com.learn.adt.queue;


public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        super("Queue object is empty");
    }
}
