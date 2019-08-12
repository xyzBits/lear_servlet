package com.google.learn.javabasic.jdbc.basic;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCUtil {
    static Properties properties = null; //可以帮助读取和处理资源文件中的信息

    static {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Connection getMySqlConnection() {
        try {
            Class.forName(properties.getProperty("mysqlDriver"));
            return DriverManager.getConnection(properties.getProperty("mysqlURL"),
                    properties.getProperty("mysqlUser"),
                    properties.getProperty("mysqlPwd"));

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public static void closeJdbcConn(AutoCloseable... all) {
        for (AutoCloseable elem: all) {
            try {
                elem.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStram(Closeable... all) {
        for (Closeable elem: all) {
            try {
                elem.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
