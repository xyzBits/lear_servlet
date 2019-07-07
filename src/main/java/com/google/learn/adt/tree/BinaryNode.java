package com.google.learn.adt.tree;

class BinaryNode<T> {
    private T data;
    private BinaryNode<T> leftChild;
    private BinaryNode<T> rightChild;

    public BinaryNode(T dataPortion, BinaryNode<T> newLeftChild, BinaryNode<T> newRightChild) {
        data = dataPortion;
        leftChild = newLeftChild;
        rightChild = newRightChild;
    }

    public BinaryNode(T dataPortion) {
        this(dataPortion, null, null);
    }

    public BinaryNode() {
        this(null);
    }
}
