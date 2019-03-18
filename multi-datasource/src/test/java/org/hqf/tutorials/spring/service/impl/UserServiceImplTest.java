package org.hqf.tutorials.spring.service.impl;

import org.hqf.tutorials.spring.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    public void addUser() {
        userService.addUser(null);
    }

    @Test
    public void queryUser() {
    }
}