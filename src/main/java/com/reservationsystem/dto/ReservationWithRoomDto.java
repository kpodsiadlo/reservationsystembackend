package com.reservationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ReservationWithRoomDto {
    public ReservationWithRoomDto() {
    }
    private Integer id;
    private LocalDateTime reservationStart;
    private LocalDateTime reservationEnd;
    private RoomDto room;
}
