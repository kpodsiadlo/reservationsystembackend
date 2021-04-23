package com.reservationsystem.dto;

import com.reservationsystem.model.Reservation;
import com.reservationsystem.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private Integer id;
    private String firstName;
    private String surname;
    private UserRole role;
    private List<Reservation> reservations;
}
