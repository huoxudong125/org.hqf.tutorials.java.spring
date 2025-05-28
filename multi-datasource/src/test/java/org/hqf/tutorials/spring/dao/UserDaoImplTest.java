package org.hqf.tutorials.spring.dao;

import org.hqf.tutorials.spring.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private UserDaoImpl userDao;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1L);
        user.setName("Test User");
        user.setAge(30);
    }

    @Test
    void insertUser() {
        when(jdbcTemplate.update(anyString(), any(), any(), any())).thenReturn(1);

        userDao.insertUser(user);

        verify(jdbcTemplate).update(
            "insert into user(id,name,age) values(?,?,?)",
            user.getId(),
            user.getName(),
            user.getAge()
        );
    }

    @Test
    void updateUser() {
        when(jdbcTemplate.update(anyString(), any(), any(), any())).thenReturn(1);

        userDao.updateUser(user);

        verify(jdbcTemplate).update(
            "update user set name =? ,age=? where id=?",
            user.getName(),
            user.getAge(),
            user.getId()
        );
    }

    @Test
    void findUsers() {
        when(jdbcTemplate.query(anyString(), any(Object[].class), any(RowMapper.class)))
            .thenReturn(Collections.singletonList(user));

        List<User> users = userDao.findUsers(user.getId());

        assertNotNull(users);
        assertEquals(1, users.size());
        assertEquals(user.getName(), users.get(0).getName());
        verify(jdbcTemplate).query(
            eq("select id,name,age from user where id=?"),
            any(Object[].class),
            any(RowMapper.class)
        );
    }
    
    @Test
    void findUsers_noResult() {
        when(jdbcTemplate.query(anyString(), any(Object[].class), any(RowMapper.class)))
            .thenReturn(Collections.emptyList());

        List<User> users = userDao.findUsers(99L); // Non-existent ID

        assertNotNull(users);
        assertTrue(users.isEmpty());
        verify(jdbcTemplate).query(
            eq("select id,name,age from user where id=?"),
            any(Object[].class),
            any(RowMapper.class)
        );
    }
}
