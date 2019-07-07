package com.google.learn.adt.tree;

import java.util.Iterator;

public class BinaryTree<T> implements BinaryTreeInterface<T> {
    private BinaryNode<T> root;


    private void privateSetTree(T rootData,
                                BinaryTree<T> leftTree,
                                BinaryTree<T> rightTree) {
        root = new BinaryNode<>(rootData);
        if (leftTree != null) {
            root.setLeftChild(leftTree.root);
        }
        if (rightTree != null) {
            root.setRightChild(rightTree.root);
        }
    }


    public BinaryTree(T rootData,
                      BinaryTree<T> leftTree,
                      BinaryTree<T> rightTree) {
        privateSetTree(rootData, leftTree, rightTree);
    }

    public BinaryTree(T rootData) {
        root = new BinaryNode<>(rootData);
    }

    public BinaryTree() {
        root = null;
    }

    @Override
    public void setTree(T rootData) {

    }

    @Override
    public void setTree(T rootData,
                        BinaryTreeInterface<T> leftTree,
                        BinaryTreeInterface<T> rightTree) {

    }

    @Override
    public T getRootData() {
        return null;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getNumberOfNodes() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Iterator<T> getPreorderIterator() {
        return null;
    }

    @Override
    public Iterator<T> getPostorderIterator() {
        return null;
    }

    @Override
    public Iterator<T> getInorderIterator() {
        return null;
    }

    @Override
    public Iterator<T> getLevelOrderIterator() {
        return null;
    }
}
