package com.google.learn.javabasic.jdbc.basic;


import java.io.File;
import java.io.FileInputStream;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 测试时间处理 测试blog 文本大对象的使用
 */
public class Demo9 {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;

        ResultSet resultSet = null;

        try {
            // 加载驱动类
            Class.forName("com.mysql.jdbc.Driver");

            // 建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "123456");


           String filePath = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\httpserver\\head.jpg";

            ps = conn.prepareStatement("insert into t_user_copy3 (username, headImg) values(?, ?);");
            ps.setObject(1, "maven");

            //将文本插入数据 库
            ps.setBlob(2, new FileInputStream(new File(filePath)));


            ps.executeUpdate();



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // resultSet --- statement  connection这样的关闭顺序
            JDBCUtil.closeJdbcConn(ps, conn);
        }
    }

    private static long strToDate(String dateStr) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return format.parse(dateStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
