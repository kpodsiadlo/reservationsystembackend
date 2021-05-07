package com.reservationsystem.service;

import com.reservationsystem.dao.UserDao;
import com.reservationsystem.dto.UserDto;
import com.reservationsystem.dto.UserWithReservationsDto;
import com.reservationsystem.entity.User;
import com.reservationsystem.mapper.UserMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
@Transactional
public class UserService {
    @Inject
    UserDao userDao;

    @Transactional
    public User createUser(User user) {
        return userDao.create(user);
    }

    @Transactional
    public UserDto readUser(Integer id) {
        return userDao.read(id);

    }

    @Transactional
    public User updateUser(User user, Integer id) {
        return userDao.update(user, id);

    }

    @Transactional
    public Boolean deleteUser(User user, Integer id) {
        return userDao.delete(user, id);

    }

    @Transactional
    public List<UserDto> getAll() {
        return userDao.findAll()
                .stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }

    public UserWithReservationsDto readUserWithReservations(Integer id) {
        return userDao.readUserWithReservations(id);
    }
}
