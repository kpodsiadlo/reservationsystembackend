package com.reservationsystem.mapper;

import com.reservationsystem.dto.RoomDto;
import com.reservationsystem.entity.Room;

import javax.ejb.Stateless;

@Stateless
public class RoomMapper {
    public static Room toRoom(RoomDto roomDto){
        return new Room(roomDto.getId(), roomDto.getDescription(),
                roomDto.getReservations());
    }

    public static RoomDto toRoomDto(Room room) {
        return new RoomDto(room.getId(), room.getDescription(), room.getReservations());
    }
}
