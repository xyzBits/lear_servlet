package com.google.learn.jvm.memory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Demo> demos = new ArrayList<>();

        while (true) {
            demos.add(new Demo());
        }
    }
}
