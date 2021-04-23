package com.reservationsystem.mapper;

import com.reservationsystem.dto.UserDto;
import com.reservationsystem.model.User;

public class UserMapper {

    private UserMapper() throws InstantiationException{
        throw new InstantiationException("That class should not be initialized");
    }
    public static User toUser(UserDto userDto) {
        return new User(userDto.getId(), 
                userDto.getFirstName(), 
                userDto.getSurname(),
                userDto.getRole(), 
                userDto.getReservations());
    }
    
    public static UserDto toUserDto(User user) {
        return new UserDto(user.getId(),
                user.getFirstName(),
                user.getSurname(),
                user.getRole(),
                user.getReservations());
    }
}
