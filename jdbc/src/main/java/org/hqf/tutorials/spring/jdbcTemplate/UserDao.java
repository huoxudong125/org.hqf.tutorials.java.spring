package org.hqf.tutorials.spring.jdbcTemplate;

import java.util.List;

import org.hqf.tutorials.spring.jdbcTemplate.bean.User;

public interface UserDao {

    //增
    void save(User u);

    //删
    void delete(Integer id);

    //改
    void update(User u);

    //查
    User getById(Integer id);

    //查
    int getTotalCount();

    //查
    List<User> getAll();
}
