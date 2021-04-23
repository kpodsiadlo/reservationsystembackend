package com.reservationsystem.service;

import com.reservationsystem.dao.UserDao;
import com.reservationsystem.dto.UserDto;
import com.reservationsystem.mapper.UserMapper;
import com.reservationsystem.model.User;

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
    @Inject
    UserMapper userMapper;

    @Transactional
    public UserDto createUser(UserDto userDto) {
        return userMapper.toUserDto(
                userDao.create(userMapper.toUser(userDto)));
    }
    @Transactional
    public UserDto readUser(Integer id) {
        return userMapper.toUserDto(
                userDao.read(id));

    }
//    @Transactional
//    public User readUser(Integer id) {
//
//        return userDao.read(id);
//    }
    @Transactional
    public UserDto updateUser(UserDto userDto, Integer id) {
        return userMapper.toUserDto(
                userDao.update(userMapper.toUser(userDto), id));

    }
    @Transactional
    public Boolean deleteUser(UserDto userDto, Integer id) {
        return userDao.delete(
                userMapper.toUser(userDto), id);

    }
    @Transactional
    public List<UserDto> getAll() {
        return userDao.findAll()
                .stream()
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }
}
