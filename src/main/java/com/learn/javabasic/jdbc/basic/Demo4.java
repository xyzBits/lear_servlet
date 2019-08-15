package com.learn.javabasic.jdbc.basic;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试PreparedStatement的基本用法
 */
public class Demo4 {

    public static void main(String[] args) {

        try {
            // 加载驱动类
            Class.forName("com.mysql.jdbc.Driver");

            // 建立连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "123456");

            String sql = "select id, username, pwd from t_user where id > ?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setObject(1, 2); //把id大于2的记录都取出来

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "-----" +
                resultSet.getString(2) + "-----" +
                resultSet.getString(3));
            }

            // resultSet --- statement  connection这样的关闭顺序
            CloseUtil.closeAll(resultSet, preparedStatement, conn);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
