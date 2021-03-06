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

    public User createUser(User user) {
        return userDao.create(user);
    }

    public UserDto readUser(Integer id) {
        return UserMapper.toUserDto(userDao.read(id));

    }

    public UserDto updateUser(User user, Integer id) {
        return UserMapper.toUserDto(userDao.update(user, id));

    }

    public Boolean deleteUser(Integer id) {
        return userDao.delete(id);

    }

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
