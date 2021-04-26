package com.reservationsystem.mapper;

import com.reservationsystem.dto.ReservationDto;
import com.reservationsystem.entity.Reservation;

public class ReservationMapper {
    public static Reservation toReservation(ReservationDto reservationDto) {
        return new Reservation(
                reservationDto.getId(),
                reservationDto.getRoom(),
                reservationDto.getReservationStart(),
                reservationDto.getReservationEnd(),
                reservationDto.getUser()
        );
    }

    public static ReservationDto toReservationDto(Reservation reservation) {
        return new ReservationDto(
                reservation.getId(),
                reservation.getRoom(),
                reservation.getReservationStart(),
                reservation.getReservationEnd(),
                reservation.getUser());
    }
}
