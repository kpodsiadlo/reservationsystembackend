package com.reservationsystem.service;

import com.reservationsystem.dao.RoomDao;
import com.reservationsystem.dto.RoomDto;
import com.reservationsystem.dto.RoomWithReservationsDto;
import com.reservationsystem.mapper.RoomMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class RoomService {
    @Inject
    RoomDao roomDao;

    public RoomDto createRoom(RoomDto roomDto) {
        return RoomMapper.toRoomDto(
                roomDao.create(
                        RoomMapper.toRoom(roomDto)));
    }

    public RoomDto readRoom(Integer id) {
        return RoomMapper.toRoomDto(
                roomDao.read(id));

    }

    public RoomWithReservationsDto readRoomWithReservations(Integer id) {
        return RoomMapper.toRoomWithReservationsDto(roomDao.readRoomWithReservations(id));
    }

    public RoomDto updateRoom(RoomDto roomDto, Integer id) {
        return RoomMapper.toRoomDto(
                roomDao.update(
                        RoomMapper.toRoom(
                                roomDto), id));

    }

    public Boolean deleteRoom(RoomDto roomDto, Integer id) {
        return roomDao.delete(
                RoomMapper.toRoom(
                        roomDto), id);

    }

    public List<RoomDto> getAll() {
        return roomDao.findAll()
                .stream()
                .map(RoomMapper::toRoomDto)
                .collect(Collectors.toList());
    }
}
