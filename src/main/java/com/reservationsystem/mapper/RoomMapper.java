package com.reservationsystem.mapper;

import com.reservationsystem.dto.RoomDto;
import com.reservationsystem.dto.RoomReservationDto;
import com.reservationsystem.dto.RoomReservationUserDto;
import com.reservationsystem.dto.RoomWithReservationsDto;
import com.reservationsystem.entity.Reservation;
import com.reservationsystem.entity.Room;
import com.reservationsystem.entity.User;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

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

    public static RoomWithReservationsDto toRoomWithReservationsDto(Room room) {
        RoomWithReservationsDto roomWithReservationsDto = new RoomWithReservationsDto();
        roomWithReservationsDto.setId(room.getId());
        roomWithReservationsDto.setDescription(room.getDescription());
        roomWithReservationsDto.setRoomNumber(room.getRoomNumber());

        List<RoomReservationDto> reservationDtos = new ArrayList<>();

        for (Reservation reservation : room.getReservations()) {
            RoomReservationDto roomReservationDto = new RoomReservationDto();
            roomReservationDto.setId(reservation.getId());
            roomReservationDto.setReservationStart(reservation.getReservationStart());
            roomReservationDto.setReservationEnd(reservation.getReservationEnd());
            roomReservationDto.setUser(RoomMapper.toRoomReservationUserDto(reservation.getUser()));
            reservationDtos.add(roomReservationDto);
        }

        roomWithReservationsDto.setReservations(reservationDtos);
        return roomWithReservationsDto;
    }

    public static RoomReservationUserDto toRoomReservationUserDto(User user) {
        RoomReservationUserDto roomReservationUserDto = new RoomReservationUserDto();
        roomReservationUserDto.setId(user.getId());
        roomReservationUserDto.setFirstName(user.getFirstName());
        roomReservationUserDto.setLastName(user.getLastName());
        return roomReservationUserDto;
    }
}
