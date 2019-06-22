package com.google.learn.adt.bag;

public class LinkedBag<T> implements BagInterface<T> {
    private class Node {
        private T data;
        private Node next;

        private Node(T dataPortion, Node nextNode) {
            this.data = dataPortion;
            this.next = nextNode;
        }

        private Node(T dataPortion) {
            this(dataPortion, null);
        }
    }

    private Node firstNode;
    private int numberOfEntries;
    private static final int MAX_CAPACITY = 10000;

    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }


    @Override
    public boolean add(T newEntry) {
        /**
         * 老师记住的是新到的学生的椅子编号
         * 也就是说，firstNode记录的是最后新添加的元素的位置，元素放置的顺序与添加的顺序是相反的
         *
         */
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public T remove() {
        /**
         T result = null;
         if (firstNode != null) {
         result = firstNode.data;
         firstNode = firstNode.next;
         numberOfEntries--;
         }
         return result;
         */
        return removeEntryAt(firstNode);
    }

    @Override
    public boolean remove(T anEntry) {
        // boolean result = false;
        Node where = getReferenceOf(anEntry);
        /**
         if (where != null) {
         where.data = firstNode.data;
         firstNode = firstNode.next;
         numberOfEntries--;
         result = true;
         }
         return result;
         */
        return removeEntryAt(where).equals(anEntry);
    }

    private T removeEntryAt(Node where) {
        T result = null;
        if (where != null) {
            result = where.data;
            where.data = firstNode.data;
            firstNode = firstNode.next;
            numberOfEntries--;
        }
        return result;
    }

    private Node getReferenceOf(T anEntry) {
        Node currentNode = firstNode;
        boolean stillLooking = true;

        while (stillLooking && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                stillLooking = false;
            }
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            remove();
        }

    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        Node currentNode = firstNode;
        int loopCounter = 0;
        while ((loopCounter < numberOfEntries) && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                frequency++;
            }
            loopCounter++;
            currentNode = currentNode.next;
        }
        return frequency;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }
        return found;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];

        Node currentNode = firstNode;
        int index = 0;
        while ((index < numberOfEntries) && currentNode != null) {
            result[index] = currentNode.data;
            currentNode = currentNode.next;
            index++;
        }

        return result;
    }

    @Override
    public void displayBag() {

    }
}
