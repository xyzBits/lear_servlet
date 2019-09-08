package com.learn.spring.mybatis;

import com.learn.spring.mybatis.bean.Employee;
import com.learn.spring.mybatis.dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class MainMyBatisTest {
    private SqlSessionFactory sqlSessionFactory = null;
    private SqlSession session = null;
    private EmployeeDao employeeDao = null;


    @Before
    public void before() throws IOException {
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession(true);
        employeeDao = session.getMapper(EmployeeDao.class);
    }

    @Test
    public void testConnection() {
        //SqlSession session = sqlSessionFactory.openSession();
        System.out.println(session);
    }

    @Test
    public void testQuery() {
        Employee employee = employeeDao.queryEmployee(1);
        System.out.println(employee);

        System.out.println(employeeDao);
    }

    @Test
    public void testInsert() {
        Employee employee = new Employee("nanfang", "nanfang@gmai.com", 1, "nanfang1");
        int row = employeeDao.addEmployee(employee);
        System.out.println(employee.getId());
        session.commit(true);
        System.out.println(row);
    }

    @Test
    public void testInsert1() {
        Employee employee = new Employee(1, "nanfang", "nanfang@gmai.com", 1, "nanfang1");
        int row = employeeDao.addEmployee1(employee);
        System.out.println(employee.getId());
        session.commit(true);
        System.out.println(row);
    }

    @Test
    public void testDelete() {
        for (int i = 3; i <= 5; i++) {
            employeeDao.deleteEmployee(i);

        }
        session.commit();
    }

    @Test
    public void testUpdate() {
        Employee employee = new Employee(6, "nanfang2", "nanfang2@gmai.com", 0, "nanfang22222");
        employeeDao.updateEmployee(employee);

        session.commit();
    }

    @Test
    public void testDaoProxy() {
        Class clzz = employeeDao.getClass();
        System.out.println(clzz);
        System.out.println(Arrays.deepToString(clzz.getInterfaces()));
        System.out.println(clzz.getSuperclass());
    }

    @Test
    public void testMultipleParameter() {
        Employee employee = employeeDao.queryEmployeeByIdAndName(1, "dongfang");
        System.out.println(employee);
    }

}