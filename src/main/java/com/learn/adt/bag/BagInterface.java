package com.learn.adt.bag;

public interface BagInterface<T> {
    boolean add(T newEntry);
    int getCurrentSize();
    boolean isEmpty();
    T remove();
    boolean remove(T anEntry);
    void clear();
    int getFrequencyOf(T anEntry);
    boolean contains(T anEntry);
    T[] toArray();
    void displayBag();
}
