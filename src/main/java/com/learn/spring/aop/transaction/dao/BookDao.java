package com.learn.spring.aop.transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateBalance(String userName, int price) {
        String sql = "update account set balance = balance - ? where username = ?";
        sql = "update ..account set balance = balance - ? where username = ?";

        jdbcTemplate.update(sql, price, userName);
    }

    public int getPrice(String isbn) {
        String sql = "select price from book where isbn = ?";
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
        return price;
    }

    public void updateBookStock(String isbn) {
        String sql = "update book_stock set stock = stock - 1 where isbn = ?";
        jdbcTemplate.update(sql, isbn);
    }
}
