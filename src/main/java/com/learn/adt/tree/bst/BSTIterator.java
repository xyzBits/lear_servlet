package com.learn.adt.tree.bst;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BSTIterator {
    private Iterator<Integer> itr;

    public BSTIterator(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        itr = list.iterator();
    }

    private void inOrder(TreeNode pointer, List<Integer> list) {
        if (pointer != null) {
            inOrder(pointer.left, list);
            list.add(pointer.val);
            inOrder(pointer.right, list);
        }
    }

    public int next() {
        return itr.next();
    }

    public boolean hasNext() {
        return itr.hasNext();
    }
}
