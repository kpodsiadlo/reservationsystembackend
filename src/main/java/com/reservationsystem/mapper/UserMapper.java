package com.reservationsystem.mapper;

import com.reservationsystem.dto.UserDto;
import com.reservationsystem.model.User;

import javax.ejb.Stateless;

@Stateless
public class UserMapper {

    public UserMapper(){
    }
    public User toUser(UserDto userDto) {
        return new User(userDto.getId(), 
                userDto.getFirstName(), 
                userDto.getSurname(),
                userDto.getRole(), 
                userDto.getReservations());
    }
    
    public UserDto toUserDto(User user) {
        return new UserDto(user.getId(),
                user.getFirstName(),
                user.getSurname(),
                user.getRole(),
                user.getReservations());
    }
}
