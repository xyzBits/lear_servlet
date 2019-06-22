package com.google.learn.adt.queue;

public interface QueueInterface<T> {
    void enqueue(T newEntry);
    T dequeue();
    T getFront();
    boolean isEmpty();
    void clear();

}
