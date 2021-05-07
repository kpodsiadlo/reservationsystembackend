package com.reservationsystem.mapper;

import com.reservationsystem.dto.ReservationDto;
import com.reservationsystem.dto.RoomDto;
import com.reservationsystem.dto.ReservationWithUserDto;
import com.reservationsystem.dto.RoomWithReservationsDto;
import com.reservationsystem.entity.Reservation;
import com.reservationsystem.entity.Room;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class RoomMapper {

    public static RoomDto toRoomDto(Room room) {
        return new RoomDto(room.getId(), room.getRoomNumber(), room.getDescription());
    }

    public static RoomWithReservationsDto toRoomWithReservationsDto(Room room) {
        RoomWithReservationsDto roomWithReservationsDto = new RoomWithReservationsDto();
        roomWithReservationsDto.setId(room.getId());
        roomWithReservationsDto.setDescription(room.getDescription());
        roomWithReservationsDto.setRoomNumber(room.getRoomNumber());

        List<ReservationWithUserDto> reservationWithUserDtos = new ArrayList<>();

        for (Reservation reservation : room.getReservations()) {
            ReservationWithUserDto reservationWithUserDto = new ReservationWithUserDto();
            reservationWithUserDto.setId(reservation.getId());
            reservationWithUserDto.setReservationStart(reservation.getReservationStart());
            reservationWithUserDto.setReservationEnd(reservation.getReservationEnd());
            reservationWithUserDto.setUser(UserMapper.toUserDto(reservation.getUser()));
            reservationWithUserDtos.add(reservationWithUserDto);
        }

        roomWithReservationsDto.setReservations(reservationWithUserDtos);
        return roomWithReservationsDto;
    }

}
