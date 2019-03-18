package org.hqf.tutorials.spring.dao;

import org.hqf.tutorials.spring.domain.User;
import org.springframework.stereotype.Component;

/**
 * @author huoquanfu
 * @date 2019/03/18
 */
@Component
public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {

    }

    @Override
    public User queryUser(Long id) {
        return null;
    }
}
