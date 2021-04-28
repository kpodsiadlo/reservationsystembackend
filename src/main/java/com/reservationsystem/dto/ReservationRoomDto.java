package com.reservationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ReservationRoomDto {
    public ReservationRoomDto() {
    }
    private Integer id;
    private String description;

}
