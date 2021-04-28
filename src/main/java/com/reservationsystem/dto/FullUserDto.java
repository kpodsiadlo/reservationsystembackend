package com.reservationsystem.dto;

import com.reservationsystem.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@AllArgsConstructor
@Data
public class FullUserDto {
    public FullUserDto() {
    }
    private Integer id;
    private String firstName;
    private String surname;
    private UserRole role;
    private List<FullUserReservationDto> reservations;

}
