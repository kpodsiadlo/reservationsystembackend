package com.reservationsystem.mapper;

import com.reservationsystem.dto.FullUserDto;
import com.reservationsystem.dto.FullUserReservationDto;
import com.reservationsystem.dto.FullUserRoomDto;
import com.reservationsystem.dto.UserDto;
import com.reservationsystem.entity.Reservation;
import com.reservationsystem.entity.Room;
import com.reservationsystem.entity.User;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserMapper {

    public UserMapper() {
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

    public static FullUserDto toFullUserDto(User user) {
        FullUserDto fullUserDto = new FullUserDto();
        fullUserDto.setId(user.getId());
        fullUserDto.setFirstName(user.getFirstName());
        fullUserDto.setSurname(user.getSurname());
        fullUserDto.setRole(user.getRole());
        List<FullUserReservationDto> fullUserReservationDtoList =
                new ArrayList<>();
        fullUserDto.setReservations(fullUserReservationDtoList);

        for (Reservation reservation : user.getReservations()) {
            FullUserReservationDto fullUserReservationDto = new FullUserReservationDto();
            fullUserReservationDto.setId(reservation.getId());
            fullUserReservationDto.setReservationStart(reservation.getReservationStart());
            fullUserReservationDto.setReservationEnd(reservation.getReservationEnd());
            fullUserReservationDto.setFullUserRoomDto(toFullUserRoomDto(reservation.getRoom()));
            fullUserReservationDtoList.add(fullUserReservationDto);
        }
        return fullUserDto;
    }


    private static FullUserRoomDto toFullUserRoomDto(Room room) {
        FullUserRoomDto fullUserRoomDto = new FullUserRoomDto();
        fullUserRoomDto.setId(room.getId());
        fullUserRoomDto.setDescription(room.getDescription());
        return fullUserRoomDto;
    }

}
