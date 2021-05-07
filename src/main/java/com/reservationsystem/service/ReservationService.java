package com.reservationsystem.service;

import com.reservationsystem.dao.ReservationDao;
import com.reservationsystem.dao.RoomDao;
import com.reservationsystem.dao.UserDao;
import com.reservationsystem.dto.IncomingReservationDto;
import com.reservationsystem.dto.ReservationDto;
import com.reservationsystem.dto.ReservationWithRoomDto;
import com.reservationsystem.entity.Reservation;
import com.reservationsystem.entity.Room;
import com.reservationsystem.entity.User;
import com.reservationsystem.mapper.ReservationMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class ReservationService {
    @Inject
    ReservationDao reservationDao;
    @Inject
    UserDao userDao;
    @Inject
    RoomDao roomDao;

    public ReservationWithRoomDto createReservation(IncomingReservationDto incomingReservationDto) {
        User user = userDao.readEntity(incomingReservationDto.getUserId());
        Room room = roomDao.read(incomingReservationDto.getRoomId());
        Reservation reservation = ReservationMapper.toReservation(
                incomingReservationDto, user, room);
        return ReservationMapper.toReservationWithRoomDto(reservationDao.create(reservation));
    }

    public ReservationDto readReservation(Integer id) {
        return ReservationMapper.toReservationDto(
                reservationDao.read(id));

    }

    public Reservation updateReservation(Reservation reservation, Integer id) {
        return (reservationDao.update(reservation, id));

    }

    public Boolean deleteReservation(Reservation reservation, Integer id) {
        return reservationDao.delete(reservation, id);

    }

    public List<ReservationDto> getAll() {
        return reservationDao.findAll()
                .stream()
                .map(ReservationMapper::toReservationDto)
                .collect(Collectors.toList());
    }
}
