package com.google.learn.javabasic.jdbc.basic;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 测试时间处理 测试clog 文本大对象的使用
 */
public class Demo8 {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;

        ResultSet resultSet = null;

        try {
            // 加载驱动类
            Class.forName("com.mysql.jdbc.Driver");

            // 建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "123456");


/**            String filePath = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\httpserver\\post.txt";

            ps = conn.prepareStatement("insert into t_user_copy3 (username, myInfo) values(?, ?);");
            ps.setObject(1, "东方");

            //将文本插入数据 库
            //ps.setClob(2, new FileReader(new File(filePath)));

            //字符串转化成流后以可以输入
            ps.setClob(2, new BufferedReader(new InputStreamReader(new ByteArrayInputStream("aaaaa".getBytes()))));
            ps.executeUpdate();*/

            // 将cblob内容取出来
             ps = conn.prepareStatement("select * from t_user_copy3 where id = ?;");
             ps.setObject(1, 9);

             resultSet = ps.executeQuery();

             while (resultSet.next()) {
                 Clob clob = resultSet.getClob("myInfo");
                 Reader reader = clob.getCharacterStream();
                 int temp = 0;
                 while ((temp = reader.read()) != -1) {
                     System.out.print((char) temp);
                 }
             }


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
