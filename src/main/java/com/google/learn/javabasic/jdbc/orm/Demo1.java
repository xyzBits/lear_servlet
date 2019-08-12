package com.google.learn.javabasic.jdbc.orm;

import com.google.learn.javabasic.jdbc.basic.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        Connection connection = JDBCUtil.getMySqlConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Emp> emps = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select empname, salary, age from emp where id >= ?;");
            preparedStatement.setObject(1, 1);
            resultSet = preparedStatement.executeQuery();

            Emp emp = null;
            while (resultSet.next()) {
                /*System.out.println(resultSet.getString(1) + "----" +
                        resultSet.getDouble(2) + "-----" +
                        resultSet.getInt(3));*/
                emp = new Emp(resultSet.getString(1), resultSet.getInt(3), resultSet.getDouble(2));
                emps.add(emp);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeJdbcConn(preparedStatement, resultSet);
        }

        for (Emp emp: emps) {
            System.out.println(emp);
        }
    }
}
