package com.reservationsystem.mapper;

import com.reservationsystem.dto.ReservationWithRoomDto;
import com.reservationsystem.dto.RoomDto;
import com.reservationsystem.dto.UserDto;
import com.reservationsystem.dto.UserWithReservationsDto;
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


    public static UserDto toUserDto(User user) {
        return new UserDto(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getRole()
        );
    }

    public static UserWithReservationsDto toFullUserDto(User user) {
        UserWithReservationsDto userWithReservationsDto = new UserWithReservationsDto();
        userWithReservationsDto.setId(user.getId());
        userWithReservationsDto.setName(user.getFirstName() + " " + user.getLastName());
        userWithReservationsDto.setRole(user.getRole());
        List<ReservationWithRoomDto> reservationWithRoomDtoList =
                new ArrayList<>();
        userWithReservationsDto.setReservations(reservationWithRoomDtoList);

        for (Reservation reservation : user.getReservations()) {
            ReservationWithRoomDto reservationWithRoomDto =
                    ReservationMapper.toReservationWithRoomDto(reservation);
            reservationWithRoomDtoList.add(reservationWithRoomDto);
        }
        return userWithReservationsDto;
    }



    private static RoomDto toRoomDto(Room room) {
        RoomDto roomDto = new RoomDto();
        roomDto.setId(room.getId());
        roomDto.setDescription(room.getDescription());
        return roomDto;
    }

}
