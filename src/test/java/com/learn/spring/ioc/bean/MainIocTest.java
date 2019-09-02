package com.learn.spring.ioc.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class MainIocTest {


    @Test
    public void testSpel() {
        ApplicationContext container = new ClassPathXmlApplicationContext("ioc1.xml");

        Person person01 = container.getBean(Person.class);
        System.out.println(person01);
    }

    @Test
    public void testAutowire() {
        ApplicationContext container = new ClassPathXmlApplicationContext("ioc1.xml");

        Object person02 = container.getBean("person03");
        System.out.println(person02);
    }

    @Test
    public void testExtend() {
        ApplicationContext container = new ClassPathXmlApplicationContext("ioc1.xml");

        Object person05 = container.getBean("person05");
        System.out.println(person05);
    }


    @Test
    public void testFactoryBean() {
        //Object bean = container.getBean("myFactoryBean");
        //System.out.println(bean);

    }

    @Test
    public void testStaticFactory() {
        ApplicationContext container = new ClassPathXmlApplicationContext("ioc1.xml");

        Object airPlane01 = container.getBean("airPlane01");
        System.out.println(airPlane01);
    }


    @Test
    public void testInstanceFactory() {
        ApplicationContext container = new ClassPathXmlApplicationContext("ioc1.xml");

        Object airPlane02 = container.getBean("airPlane02");
        System.out.println(airPlane02);
    }

    @Test
    public void testDependOn() {
         ApplicationContext container = new ClassPathXmlApplicationContext("ioc2.xml");
    }

    @Test
    public void testConnectionPool() throws SQLException {
        ApplicationContext container = new ClassPathXmlApplicationContext("ioc3.xml");
        DataSource dataSource = container.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());

    }
}