package com.reservationsystem.service;

import com.reservationsystem.dao.UserDao;
import com.reservationsystem.dto.UserDto;
import com.reservationsystem.mapper.UserMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    @Inject
    UserDao userDao;

    public UserDto createUser(UserDto userDto) {
        return UserMapper.toUserDto(
                userDao.create(UserMapper.toUser(userDto)));
    }

    public UserDto readUser(Integer id) {
        return UserMapper.toUserDto(
                userDao.read(id));

    }

    public UserDto updateUser(UserDto userDto, Integer id) {
        return UserMapper.toUserDto(
                userDao.update(UserMapper.toUser(userDto), id));

    }

    public Boolean deleteUser(UserDto userDto, Integer id) {
        return userDao.delete(
                UserMapper.toUser(userDto), id);

    }

    public List<UserDto> getAll() {
        return userDao.findAll()
                .stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }
}
