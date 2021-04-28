package com.reservationsystem.dto;

import com.reservationsystem.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@AllArgsConstructor
@Data
public class UserWithReservationsDto {
    public UserWithReservationsDto() {
    }
    private Integer id;
    private String firstName;
    private String surname;
    private UserRole role;
    private List<UserReservationsDto> reservations;

}
