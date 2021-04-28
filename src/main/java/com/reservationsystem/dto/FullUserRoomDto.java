package com.reservationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FullUserRoomDto {
    public FullUserRoomDto() {
    }
    private Integer id;
    private String description;

}
