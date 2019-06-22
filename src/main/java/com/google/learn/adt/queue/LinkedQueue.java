package com.google.learn.adt.queue;

public final class LinkedQueue<T> implements QueueInterface<T> {
    private class Node {
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    private Node firstNode;
    private Node lastNode;

    public LinkedQueue() {
        firstNode = null;
        lastNode = null;
    }


    @Override
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);
/**
 if (firstNode == null) {
 firstNode = newNode;
 lastNode = newNode;
 }

 lastNode.setNext(newNode);
 lastNode = newNode;
 */

        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.setNext(newNode);
        }
        lastNode = newNode;
    }

    @Override
    public T dequeue() {
        /**
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            T front = firstNode.getData();
            firstNode = firstNode.getNext();
            return front;
        }
         */
        T front = getFront();
        assert firstNode != null;
        firstNode.setData(null);
        // 如果是最后一个节点，firstNode.getNext() 与lastNode.getNext()指向一样，都为空，因为添加新结点 时，指向是空的

        firstNode = firstNode.getNext();
        if (firstNode == null) {
            lastNode = null;
        }
        return front;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            return firstNode.getData();
        }
    }

    @Override
    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    }

    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
    }
}
