package com.google.learn.adt.tree;

public interface TreeInterface<T> {
    T getRootData();

    int getHeight();

    int getNumberOfNodes();

    boolean isEmpty();

    void clear();
}
