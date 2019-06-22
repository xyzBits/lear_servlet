package com.google.learn.adt.stack;

public class EmptyStackException extends RuntimeException {
    public EmptyStackException() {
        super("Stack object is empty");
    }
}
