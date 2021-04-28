package com.reservationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class FullUserReservationDto {
    public FullUserReservationDto() {
    }

    private Integer id;
    private LocalDateTime reservationStart;
    private LocalDateTime reservationEnd;
    private FullUserRoomDto fullUserRoomDto;
}
