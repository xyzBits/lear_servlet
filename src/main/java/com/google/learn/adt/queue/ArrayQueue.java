package com.google.learn.adt.queue;

public class ArrayQueue<T> implements QueueInterface<T> {
    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;


    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a queue whose capacity exceeds allowed maximun of " + MAX_CAPACITY);
        }
    }

    private void checkInitialization() {
        if (!initialized) {
            throw new SecurityException("ArrayQueue object is not initialized properly");
        }
    }

    public ArrayQueue(int initialCapacity) {
        checkCapacity(initialCapacity);
/**
 @SuppressWarnings("unchecked") T[] tempQueue = (T[]) new Object[initialCapacity];
 queue = tempQueue;
 frontIndex = 0;
 backIndex = queue.length;
 initialized = true;
 */

        T[] tempQueue = (T[]) new Object[initialCapacity + 1];
        queue = tempQueue;
        frontIndex = 0;
        /**
         * 生成一个比客户给定容量大1的数组，是对客户的保证
         * 这样设置后，队列头在数组头部
         * backIndex = initialCapacity 为什么呢，这样的话，backIndex刚好在数组尾部，
         * 符合空数组的条件
         */
        backIndex = initialCapacity;
        initialized = true;
    }

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }


    private void ensureCapacity() {
        // 这是队列满的条件判断
        if (frontIndex == ((backIndex + 2) % queue.length)) {
            T[] oldQueue = queue;
            int oldLength = oldQueue.length;
            int newLength = 2 * oldLength;
            checkCapacity(newLength);

            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[]) new Object[newLength];
            queue = tempQueue;

            for (int index = 0; index < oldLength - 1; index++) {
                queue[index] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldLength;
            }

            frontIndex = 0;
            backIndex = oldLength - 2;
        }
    }

    @Override
    public void enqueue(T newEntry) {
        checkInitialization();
        ensureCapacity();
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;
    }

    @Override
    public T dequeue() {
        checkInitialization();
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            T front = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) % queue.length;
            return front;
        }
    }

    @Override
    public T getFront() {
        checkInitialization();
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            return queue[frontIndex];
        }
    }

    @Override
    public boolean isEmpty() {
        return frontIndex == ((backIndex + 1) % queue.length);
    }

    private boolean isFull() {
        return frontIndex == ((backIndex + 2) % queue.length);
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }
}
