package com.demo.mybatis.dao;

import com.demo.mybatis.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
}
