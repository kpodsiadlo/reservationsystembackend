package com.reservationsystem.service;

import com.reservationsystem.dao.UserDao;
import com.reservationsystem.dto.UserWithReservationsDto;
import com.reservationsystem.dto.UserDto;
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
    public UserDto createUser(UserDto userDto) {
        return UserMapper.toUserDto(
                userDao.create(UserMapper.toUser(userDto)));
    }
    @Transactional
    public User readUser(Integer id) {
        return userDao.read(id);

    }
    @Transactional
    public UserDto updateUser(UserDto userDto, Integer id) {
        return UserMapper.toUserDto(
                userDao.update(UserMapper.toUser(userDto), id));

    }
    @Transactional
    public Boolean deleteUser(UserDto userDto, Integer id) {
        return userDao.delete(
                UserMapper.toUser(userDto), id);

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
