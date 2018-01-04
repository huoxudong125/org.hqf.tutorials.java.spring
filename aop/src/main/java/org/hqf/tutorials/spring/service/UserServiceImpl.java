package org.hqf.tutorials.spring.service;

import org.hqf.tutorials.spring.service.interfaces.UserService;

public class UserServiceImpl implements UserService {
    public void save(long id) {
        System.out.println(String.format("保存用户 %s",id));

        //int i = 1/0;
    }

    public void delete() {
        System.out.println("删除用户");
    }

    public void update() {
        System.out.println("更新用户");
    }
}
