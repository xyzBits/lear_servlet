package com.learn.spring.mybatis.dao;

import com.learn.spring.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

public interface EmployeeDao {
    int addEmployee1(@Param("employee") Employee employee);

    int addEmployee(@Param("employee") Employee employee);

    int deleteEmployee(@Param("id") Integer id);

    int updateEmployee(@Param("employee") Employee employee);

    Employee queryEmployee(@Param("id") Integer id);

    Employee queryEmployeeByIdAndName(@Param("id") Integer id, @Param("name") String name);


}
