package org.hqf.tutorials.spring.service;

import org.hqf.tutorials.spring.domain.User;

/**
 * @author huoquanfu
 * @date 2019/03/18
 */
public interface UserService {

    void addUser(User user);

    User queryUser(Long userId);
}
