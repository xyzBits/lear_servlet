package com.google.learn.adt.queue;

public interface DequeueInterface<T> {
    void addToFront(T newEntry);
    void addToBack(T newEntry);

    T removeFront();
    T removeBack();

    boolean isEmpty();

    void clear();
}
