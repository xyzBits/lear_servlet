package com.google.learn.javabasic.jdbc.basic;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

/**
 * 测试jdbc事务
 */
public class Demo6 {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;


        try {
            // 加载驱动类
            Class.forName("com.mysql.jdbc.Driver");

            // 建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "123456");

            conn.setAutoCommit(false); //jdbc中默认是true，自动提交事务

            // 事务从这里开始
            ps1 = conn.prepareStatement("insert into t_user_copy2 (username, pwd) values(?, ?);");
            ps1.setString(1, "东方");
            ps1.setString(2, "123456");
            ps1.execute();
            System.out.println("插入一个用户");

            TimeUnit.SECONDS.sleep(30);

            ps2 = conn.prepareStatement("insert into t_user_copy2 (username, pwd, regTime) values(?, ?, ?);");
            ps2.setObject(1, "李慧");
            ps2.setObject(2, "998");
            ps2.execute();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // resultSet --- statement  connection这样的关闭顺序
            JDBCUtil.closeJdbcConn(ps1, ps2, conn);
        }
    }
}
