package com.reservationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class UserReservationsDto {
    public UserReservationsDto() {
    }

    private Integer id;
    private LocalDateTime reservationStart;
    private LocalDateTime reservationEnd;
    private ReservationRoomDto fullUserRoomDto;
}
