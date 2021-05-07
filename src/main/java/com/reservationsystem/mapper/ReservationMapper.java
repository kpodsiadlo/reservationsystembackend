package com.reservationsystem.mapper;

import com.reservationsystem.dto.IncomingReservationDto;
import com.reservationsystem.dto.ReservationDto;
import com.reservationsystem.dto.ReservationWithRoomDto;
import com.reservationsystem.entity.Reservation;
import com.reservationsystem.entity.Room;
import com.reservationsystem.entity.User;

public class ReservationMapper {
    public static ReservationDto toReservationDto(Reservation reservation) {
        return new ReservationDto(
                reservation.getId(),
                reservation.getReservationStart(),
                reservation.getReservationEnd()
        );
    }

    public static Reservation toReservation(
            IncomingReservationDto incomingReservationDto,
            User user,
            Room room
    ) {
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setRoom(room);
        reservation.setReservationEnd(incomingReservationDto.getReservationStart());
        reservation.setReservationStart(incomingReservationDto.getReservationEnd());
        return reservation;
    }

    public static ReservationWithRoomDto toReservationWithRoomDto(Reservation reservation) {
        ReservationWithRoomDto reservationWithRoomDto = new ReservationWithRoomDto();
        reservationWithRoomDto.setId(reservation.getId());
        reservationWithRoomDto.setReservationStart(reservation.getReservationStart());
        reservationWithRoomDto.setReservationEnd(reservation.getReservationEnd());
        reservationWithRoomDto.setRoom(RoomMapper.toRoomDto(reservation.getRoom()));
        return reservationWithRoomDto;
    }

}
