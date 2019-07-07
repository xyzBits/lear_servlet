package com.google.learn.adt.tree;

class BinaryNode<T> {
    private T data;
    private BinaryNode<T> leftChild;
    private BinaryNode<T> rightChild;

    public BinaryNode(T dataPortion,
                      BinaryNode<T> newLeftChild,
                      BinaryNode<T> newRightChild) {
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

    public T getData() {
        return data;
    }

    public void setDate(T newData) {
        this.data = newData;
    }

    public BinaryNode<T> getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(BinaryNode<T> newLeftChild) {
        this.leftChild = newLeftChild;
    }

    public boolean hasLeftChild() {
        return leftChild != null;
    }

    public BinaryNode<T> getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(BinaryNode<T> newRightChild) {
        this.rightChild = newRightChild;
    }

    public boolean hasRightChild() {
        return rightChild != null;
    }

    public boolean isLeaf() {
        return (leftChild == null) && (rightChild == null);
    }

    public int getNumberOfNodes() {
        return 0;
    }

    public int getHeight() {
        return 0;
    }

    public BinaryNode<T> copy() {
        return null;
    }
}
