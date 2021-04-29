package com.reservationsystem.dao;

import com.reservationsystem.entity.User;
import com.reservationsystem.entity.UserRole;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    UserDao userDao = new UserDao();

    @Test
    void create() {
        User user = new User();
        user.setFirstName("asd");
        user.setLastName("sdf");
        user.setRole(UserRole.USER);
        User user1 = userDao.create(user);
        assertEquals(user.getFirstName(), user1.getFirstName());
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findAll() {
    }
}