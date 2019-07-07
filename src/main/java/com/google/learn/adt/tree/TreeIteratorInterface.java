package com.google.learn.adt.tree;

import java.util.Iterator;

public interface TreeIteratorInterface<T> {
    Iterator<T> getPreorderIterator();

    Iterator<T> getPostorderIterator();

    Iterator<T> getInorderIterator();

    Iterator<T> getLevelOrderIterator();
}
