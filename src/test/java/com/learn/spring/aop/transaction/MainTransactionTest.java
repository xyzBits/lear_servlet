package com.learn.spring.aop.transaction;

import com.learn.spring.aop.transaction.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations = "classpath:transaction.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTransactionTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testDbConnection() {
        System.out.println(jdbcTemplate);
    }


    @Autowired
    private BookService bookService;

    @Test
    public void testTx() {
        bookService.checkout("Tom", "ISBN-001");
    }

}