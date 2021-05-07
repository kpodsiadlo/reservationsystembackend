package com.reservationsystem.dto;

import com.reservationsystem.entity.Reservation;
import com.reservationsystem.entity.UserRole;
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
    private String lastName;
    private UserRole role;
}
