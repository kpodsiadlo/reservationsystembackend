package com.reservationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomReservationUserDto {
    private Integer id;
    private String firstName;
    private String lastName;
}