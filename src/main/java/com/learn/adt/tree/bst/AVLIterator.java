package com.learn.adt.tree.bst;

import java.util.Iterator;
import java.util.Stack;

public class AVLIterator<K, V> implements Iterator<AVLEntry<K, V>> {
    private Stack<AVLEntry<K, V>> stack;

    public AVLIterator(AVLEntry<K, V> root) {
        stack = new Stack<>();
        addLeftPath(root);
    }

    private void addLeftPath(AVLEntry<K, V> pointer) {
        while (pointer != null) {
            stack.push(pointer);
            pointer = pointer.left;
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty(); //非空才有下一个
    }

    @Override
    public AVLEntry<K, V> next() {
        AVLEntry<K, V> pointer = stack.pop();
        addLeftPath(pointer.right);
        return pointer;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Do not support remove operation");
    }
}
