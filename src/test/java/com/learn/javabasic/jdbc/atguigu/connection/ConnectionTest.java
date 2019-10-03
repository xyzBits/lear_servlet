package com.learn.javabasic.jdbc.atguigu.connection;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionTest {

    @Test
    public void testConnection() throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();

        String url = "jdbc:mysql://localhost:3306/test";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");

        Connection connection = driver.connect(url, properties);
        System.out.println(connection);
    }

    // 程序中没有第三方的api，有较好的移植性
    @Test
    public void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        String driverClass = "com.mysql.jdbc.Driver";
        Class clazz = Class.forName(driverClass);
        Driver driver = (Driver) clazz.newInstance();

        String url = "jdbc:mysql://localhost:3306/test";
        Properties prop = new Properties();
        prop.setProperty("user", "root");
        prop.setProperty("password", "123456");

        Connection connect = driver.connect(url, prop);
        System.out.println(connect);
    }

    @Test
    public void test03() throws Exception {
        String driverClass = "com.mysql.jdbc.Driver";
        Class clazz = Class.forName(driverClass);
        Driver driver = (Driver) clazz.newInstance();
        DriverManager.registerDriver(driver);

        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    @Test
    public void test004() throws Exception {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";

        String driverClass = "com.mysql.jdbc.Driver";
        Class clazz = Class.forName(driverClass);

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    @Test
    public void test005() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream("test/jdbc.properties");

        Properties prop = new Properties();
        prop.load(is);
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        String url = prop.getProperty("url");
        String driverClass = prop.getProperty("driverClass");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    @Test
    public void test006() throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";
        Properties info = new Properties();
        info.setProperty("user", user);
        info.setProperty("password", password);

        Connection connect = driver.connect(url, info);
        System.out.println(connect);
    }

}