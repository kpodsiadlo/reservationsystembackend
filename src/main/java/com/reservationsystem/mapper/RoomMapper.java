package com.reservationsystem.mapper;

import com.reservationsystem.dto.RoomDto;
import com.reservationsystem.model.Room;

public class RoomMapper {
    public static Room toRoom(RoomDto roomDto){
        return new Room(roomDto.getId(), roomDto.getReservations());
    }

    public static RoomDto toRoomDto(Room room) {
        return new RoomDto(room.getId(), room.getReservations());
    }
}
