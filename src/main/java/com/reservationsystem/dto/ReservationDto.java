package com.reservationsystem.dto;

import com.reservationsystem.entity.Room;
import com.reservationsystem.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservationDto {
    private Integer id;
    private Room room;
    private LocalDateTime reservationStart;
    private LocalDateTime reservationEnd;
    private User user;
}
