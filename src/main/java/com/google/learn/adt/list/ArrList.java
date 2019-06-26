package com.google.learn.adt.list;

import java.util.Arrays;

public class ArrList<T> implements ListInterface<T> {
    private T[] list;
    private int numberOfEntries;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public ArrList(int initialCapacity) {
        if (initialCapacity < DEFAULT_CAPACITY) {
            initialCapacity = DEFAULT_CAPACITY;
        } else {
            checkCapacity(initialCapacity);
        }

        // 为什么要生成一个比客户指定容量大1的数组，请看ensureCapacity()方法
        @SuppressWarnings("unchecked")
        T[] tempList = (T[]) new Object[initialCapacity + 1];
        list = tempList;
        numberOfEntries = 0;
        initialized = true;
    }

    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a list whose capacity exceeds allowed maximun of " + MAX_CAPACITY);
        }
    }

    private void checkInitialization() {
        if (!initialized) {
            throw new SecurityException("ArrayList object is not initialized properly");
        }
    }

    @Override
    public void add(T newEntry) {
        checkInitialization();
        list[numberOfEntries] = newEntry;
        numberOfEntries++;
        // 为什么要在添加后才对数组扩容，请查看ensureCapacity()方法的注释
        /**
         * 包 栈 队列中，添加前扩容，如果容量比较大，客户就要等待
         * 可以在初始化数组时，就初始化一个比客户指定容量大1的数组
         * 而且ensureCapacity()方法会在数组还有一个位置时就扩容
         */
        ensureCapacity();

        /**
         * add(numberOfEntries, newEntry);另一种实现
         */
    }

    private void ensureCapacity() {
        int capacity = list.length - 1;
        if (numberOfEntries >= capacity) {
            int newCapacity = capacity * 2;
            checkCapacity(newCapacity);
            list = Arrays.copyOf(list, newCapacity + 1);
        }
    }

    @Override
    public void add(int newPosition, T newEntry) {
        checkInitialization();
        if ((newPosition >= 0) && (newPosition < numberOfEntries)) {
            if (newPosition < numberOfEntries) {
                makeRoom(newPosition);
            }
            list[newPosition] = newEntry;
            numberOfEntries++;
            ensureCapacity();
        } else {
            throw new IndexOutOfBoundsException("Given position of add's new entry is out of bounds");
        }
    }

    private void makeRoom(int newPosition) {
        assert (newPosition >= 0) && (newPosition < numberOfEntries);

        int lastIndex = numberOfEntries;
        for (int index = lastIndex; index >= newPosition; index--) {
            list[index + 1] = list[index];
        }
    }

    @Override
    public T remove(int givenPosition) {
        checkInitialization();
        if ((givenPosition >= 0) && (givenPosition < numberOfEntries)) {
            assert !isEmpty();
            T result = list[givenPosition];
            removeGap(givenPosition);

            numberOfEntries--;
            return result;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
        }
    }

    private void removeGap(int givenPosition) {
        assert (givenPosition >= 0) && (givenPosition < numberOfEntries);

        int lastIndex = numberOfEntries;
        for (int index = givenPosition; index < lastIndex; index++) {
            list[index] = list[index + 1];
        }
    }

    @Override
    public void clear() {

    }

    @Override
    public T replace(int givenPosition, T newEntry) {
        checkInitialization();
        if ((givenPosition >= 0) && (givenPosition < numberOfEntries)) {
            assert !isEmpty();
            T originalEntry = list[givenPosition];
            list[givenPosition] = newEntry;
            return originalEntry;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
        }
    }

    @Override
    public T getEntry(int givenPosition) {
        checkInitialization();
        if ((givenPosition >= 0) && (givenPosition < numberOfEntries)) {
            assert !isEmpty();
            return list[givenPosition];
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
        }
    }

    @Override
    public T[] toArray() {
        checkInitialization();

        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = list[index];
        }
        return result;
    }

    @Override
    public boolean contains(T anEntry) {
        checkInitialization();
        boolean found = false;
        int index = 0;

        while (!found && (index < numberOfEntries)) {
            if (anEntry.equals(list[index])) {
                found = true;
            }
            index++;
        }
        return found;
    }

    @Override
    public int getLength() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }
}
