package org.hqf.tutorials.spring.service;

import org.hqf.tutorials.spring.constants.DataSourceTypeEnum;
import org.hqf.tutorials.spring.domain.User;
import org.hqf.tutorials.spring.interceptor.CustomDtaSource;

/**
 * @author huoquanfu
 * @date 2019/03/18
 */
public interface UserService {

    @CustomDtaSource
    void addUser(User user);

    @CustomDtaSource(DataSourceTypeEnum.Slave)
    User queryUser(Long userId);
}
