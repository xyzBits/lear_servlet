package com.learn.javabasic.jdbc.basic;

public class CloseUtil {
    public static void closeAll(AutoCloseable... all) {
        for (AutoCloseable elem: all) {
            try {
                elem.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
