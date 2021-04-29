package com.reservationsystem.mapper;

import com.reservationsystem.dto.UserWithReservationsDto;
import com.reservationsystem.dto.UserReservationsDto;
import com.reservationsystem.dto.ReservationRoomDto;
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

    public static User toUser(UserDto userDto) {
        return new User(userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getRole(),
                userDto.getReservations());
    }

    public static UserDto toUserDto(User user) {
        return new UserDto(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getRole(),
                user.getReservations());
    }

    public static UserWithReservationsDto toFullUserDto(User user) {
        UserWithReservationsDto userWithReservationsDto = new UserWithReservationsDto();
        userWithReservationsDto.setId(user.getId());
        userWithReservationsDto.setName(user.getFirstName() + " " + user.getLastName());
        userWithReservationsDto.setRole(user.getRole());
        List<UserReservationsDto> userReservationsDtoList =
                new ArrayList<>();
        userWithReservationsDto.setReservations(userReservationsDtoList);

        for (Reservation reservation : user.getReservations()) {
            UserReservationsDto userReservationsDto = new UserReservationsDto();
            userReservationsDto.setId(reservation.getId());
            userReservationsDto.setReservationStart(reservation.getReservationStart());
            userReservationsDto.setReservationEnd(reservation.getReservationEnd());
            userReservationsDto.setRoom(toReservationRoomDto(reservation.getRoom()));
            userReservationsDtoList.add(userReservationsDto);
        }
        return userWithReservationsDto;
    }


    private static ReservationRoomDto toReservationRoomDto(Room room) {
        ReservationRoomDto reservationRoomDto = new ReservationRoomDto();
        reservationRoomDto.setId(room.getId());
        reservationRoomDto.setDescription(room.getDescription());
        return reservationRoomDto;
    }

}
