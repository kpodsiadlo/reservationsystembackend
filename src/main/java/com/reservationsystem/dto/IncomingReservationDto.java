package com.reservationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class IncomingReservationDto {
    private Integer id;
    private LocalDateTime reservationStart;
    private LocalDateTime reservationEnd;
    private Integer userId;
    private Integer roomId;
}