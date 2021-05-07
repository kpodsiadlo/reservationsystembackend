package com.reservationsystem.mapper;

import com.reservationsystem.dto.RoomDto;
import com.reservationsystem.entity.Room;

import javax.ejb.Stateless;

@Stateless
public class RoomMapper {
    public static Room toRoom(RoomDto roomDto) {
        return new Room(roomDto.getId(), roomDto.getRoomNumber(), roomDto.getDescription(),
                roomDto.getReservations());
    }

    public static RoomDto toRoomDto(Room room) {
        return new RoomDto(room.getId(), room.getRoomNumber(), room.getDescription(),
                room.getReservations());
    }
}
