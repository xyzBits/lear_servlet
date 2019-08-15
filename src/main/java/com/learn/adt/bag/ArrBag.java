package com.learn.adt.bag;

import java.util.Arrays;

public class ArrBag<T> implements BagInterface<T> {
    private T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;

    /**
     * 这两个是安全机制，第一个确保数组初始化成功，因为有时候内存不足
     * 第二个是防止数组的容量太大
     */
    private boolean initialized = false;
    private static final int MAX_CAPACITY = 10000;

    public ArrBag(int desiredCapacity) {
        checkCapacity(desiredCapacity);

        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[desiredCapacity];
        bag = tempBag;
        numberOfEntries = 0;
        initialized = true;
    }

    public ArrBag() {
        this(DEFAULT_CAPACITY);
    }

    private boolean isArrayFul() {
        return numberOfEntries >= bag.length;
    }

    private void doubleCapacity() {
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);

    }

    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximun of " + MAX_CAPACITY);
        }
    }

    private void checkInitialization() {
        if (!initialized) {
            throw new SecurityException("ArrayBag object is not initialized properly");
        }
    }


    @Override
    public boolean add(T newEntry) {
        checkInitialization();
        if (isArrayFul()) {
            doubleCapacity();
        }

        bag[numberOfEntries] = newEntry;
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
        checkInitialization();
        return removeEntryAt(numberOfEntries - 1);
    }

    @Override
    public boolean remove(T anEntry) {
        checkInitialization();
        int where = getIndexOf(anEntry);
        T result = removeEntryAt(where);
        return anEntry.equals(result);
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    private T removeEntryAt(int givenIndex) {
        T result = null;
        if (!isEmpty() && (givenIndex >= 0)) {
            result = bag[givenIndex];
            bag[givenIndex] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
        }
        return result;
    }

    private int getIndexOf(T anEntry) {
        int where = -1;
        boolean stillLooking = true;
        int index = 0;
        while (stillLooking && (index < numberOfEntries)) {
            if (anEntry.equals(bag[index])) {
                where = index;
                stillLooking = false;
            }
            index++;
        }
        return where;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        for (int index = 0; index < numberOfEntries; index++) {
            if (anEntry.equals(bag[index])) {
                frequency++;
            }
        }
        return frequency;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        int index = 0;
        while (!found && (index < numberOfEntries)) {
            if (anEntry.equals(bag[index])) {
                found = true;
            }
            index++;
        }
        return found;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];

        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = bag[index];
        }

        return result;
    }

    @Override
    public void displayBag() {

    }
}
