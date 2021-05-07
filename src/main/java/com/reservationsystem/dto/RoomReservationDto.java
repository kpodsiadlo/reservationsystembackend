package com.reservationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomReservationDto {
    private Integer id;
    private LocalDateTime reservationStart;
    private LocalDateTime reservationEnd;
    private ReservationUserDto user;
}