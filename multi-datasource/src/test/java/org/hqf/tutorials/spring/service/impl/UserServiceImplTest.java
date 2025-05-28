package org.hqf.tutorials.spring.service.impl;

import org.hqf.tutorials.spring.dao.UserDao;
import org.hqf.tutorials.spring.domain.User;
import org.hqf.tutorials.spring.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserServiceImpl userService;

    private User user1;
    private User user2;

    @BeforeEach
    void setUp() {
        user1 = new User();
        user1.setId(1L);
        user1.setName("Test User 1");
        user1.setAge(30);

        user2 = new User();
        user2.setId(2L);
        user2.setName("Test User 2");
        user2.setAge(25);
    }

    @Test
    void addUsers() {
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        // No return value to mock for userDao.insertUser as it's void

        userService.addUsers(users);

        // Verify that userDao.insertUser was called for each user in the list
        verify(userDao, times(1)).insertUser(user1);
        verify(userDao, times(1)).insertUser(user2);
    }
    
    @Test
    void addUsers_emptyList() {
        List<User> users = Collections.emptyList();

        userService.addUsers(users);

        // Verify that userDao.insertUser was never called
        verify(userDao, never()).insertUser(any(User.class));
    }

    @Test
    void updateUser() {
        // No return value to mock for userDao.updateUser as it's void
        userService.updateUser(user1);
        verify(userDao, times(1)).updateUser(user1);
    }
    
    @Test
    void updateUser_nullUser() {
        // Check if the service handles null input gracefully, 
        // assuming it should not call DAO for null user.
        // Depending on actual implementation, it might throw NPE or have specific handling.
        // For this test, we assume it does nothing if user is null.
        userService.updateUser(null);
        verify(userDao, never()).updateUser(any(User.class));
    }


    @Test
    void findUsers() {
        when(userDao.findUsers(user1.getId())).thenReturn(Collections.singletonList(user1));

        List<User> foundUsers = userService.findUsers(user1.getId());

        assertNotNull(foundUsers);
        assertEquals(1, foundUsers.size());
        assertEquals(user1.getName(), foundUsers.get(0).getName());
        verify(userDao, times(1)).findUsers(user1.getId());
    }
    
    @Test
    void findUsers_notFound() {
        Long nonExistentId = 99L;
        when(userDao.findUsers(nonExistentId)).thenReturn(Collections.emptyList());

        List<User> foundUsers = userService.findUsers(nonExistentId);

        assertNotNull(foundUsers);
        assertTrue(foundUsers.isEmpty());
        verify(userDao, times(1)).findUsers(nonExistentId);
    }
}
