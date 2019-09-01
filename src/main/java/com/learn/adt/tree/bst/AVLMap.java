package com.learn.adt.tree.bst;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class AVLMap<K, V> implements Iterable<AVLEntry<K, V>> {
    private int size;
    private AVLEntry<K, V> root;

    private Comparator<K> comp;

    @SuppressWarnings("unchecked")
    private int compare(K a, K b) {
        if (comp != null) {
            return comp.compare(a, b);
        } else {
            Comparable<K> c = (Comparable<K>) a;
            return c.compareTo(b);
        }
    }

    public AVLMap(Comparator<K> comp) {
        this.comp = comp;
    }

    public AVLMap() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V put(K key, V value) {
        if (root == null) {
            root = new AVLEntry<>(key, value);
            size++;
        } else {
            AVLEntry<K, V> pointer = root;
            while (pointer != null) {
                int compareResult = compare(key, pointer.key);
                if (compareResult == 0) {
                    pointer.setValue(value);
                    break;
                } else if (compareResult < 0) {
                    if (pointer.left == null) {
                        pointer.left = new AVLEntry<>(key, value);
                        size++;
                        break;
                    } else {
                        pointer = pointer.left;
                    }
                } else {
                    if (pointer.right == null) {
                        pointer.right = new AVLEntry<>(key, value);
                        size++;
                        break;
                    } else {
                        pointer = pointer.right;
                    }
                }
            }
        }

        return value;
    }

    @Override
    public Iterator<AVLEntry<K, V>> iterator() {
        return new AVLIterator<>(root);
    }


    private AVLEntry<K, V> getEntry(K key) {
        AVLEntry<K, V> pointer = root;

        while (pointer != null) {
            int compareResult = compare(key, pointer.getKey());
            if (compareResult == 0) {
                return pointer;
            } else if (compareResult < 0) {
                pointer = pointer.left;
            } else {
                pointer = pointer.right;
            }
        }

        return null;
    }

    public V get(K key) {
        AVLEntry<K, V> pointer = getEntry(key);
        return pointer != null ? pointer.getValue() : null;
    }

    public boolean containsKey(K key) {
        return getEntry(key) != null;
    }

    public boolean containsValue(V value) {
        Iterator<AVLEntry<K, V>> itr = this.iterator();
        while (itr.hasNext()) {
            if (itr.next().getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public AVLEntry<K, V> getFirstEntry(AVLEntry<K, V> pointer) {
        if (pointer == null) {
            return null;
        }
        while (pointer.left != null) {
            pointer = pointer.left;
        }

        return pointer;
    }

    public AVLEntry<K, V> getLastEntry(AVLEntry<K, V> pointer) {
        if (pointer == null) {
            return null;
        }

        while (pointer.right != null) {
            pointer = pointer.right;
        }

        return pointer;
    }

    public V remove(K key) {
        AVLEntry<K, V> entry = getEntry(key);
        if (entry == null) {
            return null;
        }

        V oldValue = entry.getValue();
        root = deleteEntry(root, key);
        size--;
        return oldValue;
    }

    /**
     * 在子树pointer中删除key的结点
     *
     * @param pointer
     * @param key
     * @return
     */
    private AVLEntry<K, V> deleteEntry(AVLEntry<K, V> pointer, K key) {
        if (pointer == null) {
            return null;
        } else {
            int compareResult = compare(key, pointer.key);
            if (compareResult == 0) {//找到了
                if (pointer.left == null && pointer.right == null) {
                    //叶子结点，直接删除
                    pointer = null;

                } else if (pointer.left != null && pointer.right == null) {
                    pointer = pointer.left;
                } else if (pointer.left == null && pointer.right != null) {
                    pointer = pointer.right;
                } else {
                    if ((size & 1) == 0) { //只有一个根节点
                        AVLEntry<K, V> rightMin = getFirstEntry(pointer.right);
                        pointer.key = rightMin.key;
                        pointer.value = rightMin.value;
                        AVLEntry<K, V> newRight = deleteEntry(pointer.right, pointer.key);
                        pointer.right = newRight;
                    } else {
                        AVLEntry<K, V> leftMax = getLastEntry(pointer.left);
                        pointer.key = leftMax.key;
                        pointer.value = leftMax.value;
                        AVLEntry<K, V> newLeft = deleteEntry(pointer.left, pointer.key);
                        pointer.left = newLeft;
                    }
                }
            } else if (compareResult < 0) {
                AVLEntry<K, V> newLeft = deleteEntry(pointer.left, key);
                pointer.left = newLeft;
            } else {
                AVLEntry<K, V> newRight = deleteEntry(pointer.right, key);
                pointer.right = newRight;
            }
            return pointer;
        }
    }


    public void levelOrder() {
        Queue<AVLEntry<K, V>> queue = new LinkedList<>();
        queue.offer(root);
        int preCount = 1;
        int pCount = 0;

        while (!queue.isEmpty()) {
            preCount--;
            AVLEntry<K, V> pointer = queue.poll();
            System.out.print(pointer + "");
            if (pointer.left != null) {
                queue.offer(pointer.left);
                pCount++;
            }

            if (pointer.right != null) {
                queue.offer(pointer.right);
                pCount++;
            }

            if (preCount == 0) {
                preCount = pCount;
                pCount = 0;
                System.out.println();
            }
        }
    }

}
