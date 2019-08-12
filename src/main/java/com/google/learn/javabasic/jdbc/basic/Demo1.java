package com.google.learn.javabasic.jdbc.basic;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 测试与数据 库建立 连接
 */
public class Demo1 {

    public static void main(String[] args) {

        try {
            // 加载驱动类
            Class.forName("com.mysql.jdbc.Driver");

            // 建立连接
            // 连接对象内部其实包含了socket对象，是一个远程连接，比较耗时，这是connection连接对象管理的一个要点
            // 真正的开发中，为了提高效率，都会使用连接池来管理连接对象
            long start = System.currentTimeMillis();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "123456");
            long end = System.currentTimeMillis();
            System.out.println("建立连接，耗时 ----> " + (end - start));
            System.out.println(conn);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
