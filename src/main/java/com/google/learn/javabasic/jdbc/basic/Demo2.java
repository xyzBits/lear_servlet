package com.google.learn.javabasic.jdbc.basic;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试执行sql语句，以及sql注入问题
 */
public class Demo2 {

    public static void main(String[] args) {

        try {
            // 加载驱动类
            Class.forName("com.mysql.jdbc.Driver");

            // 建立连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "123456");

            Statement statement = conn.createStatement();
           /* String sql = "insert into t_user (username, pwd, regTime) values('赵六', 6666, now());";
            statement.execute(sql);*/

            // 给sql传入参数
/*            String name = "李东方";
            String sql = "insert into t_user (username, pwd, regTime) values('" + name + "', 4243223, now());";
            statement.execute(sql);*/

            // 测试sql注入 传入恶意的代码，破坏数据库
            String id = "5 or 1 = 1";
            String sql = "delete from t_user_copy1 where id = " + id;
            statement.execute(sql);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
