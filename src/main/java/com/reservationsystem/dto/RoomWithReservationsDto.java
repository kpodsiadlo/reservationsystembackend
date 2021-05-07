package com.reservationsystem.dto;

import com.reservationsystem.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomWithReservationsDto {

    private Integer id;
    private String roomNumber;
    private String description;
    private List<RoomReservationDto> reservations;

}