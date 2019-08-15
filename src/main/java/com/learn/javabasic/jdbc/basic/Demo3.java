package com.learn.javabasic.jdbc.basic;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试PreparedStatement的基本用法
 */
public class Demo3 {

    public static void main(String[] args) {

        try {
            // 加载驱动类
            Class.forName("com.mysql.jdbc.Driver");

            // 建立连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "123456");

            String sql = "insert into t_user (username, pwd, regTime) values(?, ?, ?);"; // ?点位符
            PreparedStatement preparedStatement = conn.prepareStatement(sql);


/*            preparedStatement.setString(1, "李东方"); // 参数索引从1开始计算，而不是0
            preparedStatement.setString(2, "920930");
            System.out.println("插入一条记录");
            preparedStatement.execute();*/

            // 可以使用setObject()方法处理所有参数

            preparedStatement.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            preparedStatement.setObject(1, "李东方1");
            preparedStatement.setObject(2, "3533");
            preparedStatement.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
