package com.google.learn.javabasic.jdbc.basic;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 测试时间处理 java.sql.Date Time TimeStamp
 */
public class Demo7 {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps1 = null;

        ResultSet resultSet = null;


        try {
            // 加载驱动类
            Class.forName("com.mysql.jdbc.Driver");

            // 建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "123456");

            // 插入一定时间内的数据
/**            for (int i = 0; i < 1000; i++) {
                ps1 = conn.prepareStatement("insert into t_user_copy2 (username, pwd, regTime, lastLoginTime) values (?, ?, ?, ?);");
                ps1.setObject(1, "dongfang");
                ps1.setObject(2, "0089");


                int rand = 1_000_000_000 + new Random().nextInt(1_000_000_000);
                //这个时间只有年月日
                java.sql.Date date = new java.sql.Date(System.currentTimeMillis() - rand);
                ps1.setDate(3, date);

                Timestamp timestamp = new Timestamp(System.currentTimeMillis() - rand);
                ps1.setTimestamp(4, timestamp);
                ps1.execute();
            }*/
            ps1 = conn.prepareStatement("select * from t_user_copy2 where regTime > ? and regTime < ?;");

            java.sql.Date start = new java.sql.Date(strToDate("2019-07-28 13:43:40"));
            java.sql.Date end = new java.sql.Date(strToDate("2019-08-1 13:43:40"));

            ps1.setObject(1, start);
            ps1.setObject(2, end);

            resultSet = ps1.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "----" +
                resultSet.getString("username") + "----" +
                resultSet.getTimestamp("lastLoginTime"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // resultSet --- statement  connection这样的关闭顺序
            JDBCUtil.closeJdbcConn(ps1, conn);
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
