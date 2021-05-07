package com.reservationsystem.service;

import com.reservationsystem.dao.RoomDao;
import com.reservationsystem.dto.RoomDto;
import com.reservationsystem.dto.RoomWithReservationsDto;
import com.reservationsystem.entity.Room;
import com.reservationsystem.mapper.RoomMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class RoomService {
    @Inject
    RoomDao roomDao;

    public Room createRoom(Room room) {
        return roomDao.create(room);
    }

    public RoomDto readRoom(Integer id) {
        return RoomMapper.toRoomDto(
                roomDao.read(id));

    }

    public RoomWithReservationsDto readRoomWithReservations(Integer id) {
        return RoomMapper.toRoomWithReservationsDto(roomDao.readRoomWithReservations(id));
    }

    public List<RoomDto> getAll() {
        return roomDao.findAll()
                .stream()
                .map(RoomMapper::toRoomDto)
                .collect(Collectors.toList());
    }

    public Room updateRoom(Room room, Integer id) {
        return roomDao.update(room,id);

    }

    public Boolean deleteRoom(Room room, Integer id) {
        return roomDao.delete(room,id);

    }
}
