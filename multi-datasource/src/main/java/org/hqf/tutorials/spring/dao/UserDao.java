package org.hqf.tutorials.spring.dao;

import org.hqf.tutorials.spring.domain.User;
import org.springframework.stereotype.Component;

/**
 * @author huoquanfu
 * @date 2019/03/18
 */

public interface UserDao {
   void add(User user);

   User queryUser(Long id);
}
