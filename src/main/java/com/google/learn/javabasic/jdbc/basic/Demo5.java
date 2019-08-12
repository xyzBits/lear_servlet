package com.google.learn.javabasic.jdbc.basic;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试批处理的基本用法
 */
public class Demo5 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;

        try {
            // 加载驱动类
            Class.forName("com.mysql.jdbc.Driver");

            // 建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "123456");

            // 设为手动提交  jdbc的事务是默认自动提交的  最后提交
            conn.setAutoCommit(false);

            long start = System.currentTimeMillis();
            statement = conn.createStatement();

            for (int i = 0; i < 2_000_000; i++) {
                statement.addBatch("insert into t_user_copy1 (username, pwd, regTime) " +
                        "values ('dongfang" + i +"', 6666, now());");
            }

            statement.executeBatch();
            conn.commit(); //提交事务
            long end = System.currentTimeMillis();
            System.out.println("插入2_000_000条数据耗时为 " + (end - start ));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // resultSet --- statement  connection这样的关闭顺序
            CloseUtil.closeAll(statement, conn);
        }
    }
}
