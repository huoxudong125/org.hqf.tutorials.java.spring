package org.hqf.tutorials.spring.service.impl;

import org.hqf.tutorials.spring.dao.UserDao;
import org.hqf.tutorials.spring.domain.User;
import org.hqf.tutorials.spring.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author huoquanfu
 * @date 2019/03/18
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    @Override
    public void addUser(User user) {

    }

    @Override
    public User queryUser(Long userId) {
        return null;
    }
}
