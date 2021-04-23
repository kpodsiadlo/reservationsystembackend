package com.reservationsystem.service;

import com.reservationsystem.dao.ReservationDao;
import com.reservationsystem.dto.ReservationDto;
import com.reservationsystem.mapper.ReservationMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationService {
    @Inject
    ReservationDao reservationDao;

    public ReservationDto createReservation(ReservationDto reservationDto) {
        return ReservationMapper.toReservationDto(
                reservationDao.create(
                        ReservationMapper.toReservation(reservationDto)));
    }

    public ReservationDto readReservation(Integer id) {
        return ReservationMapper.toReservationDto(
                reservationDao.read(id));

    }

    public ReservationDto updateReservation(ReservationDto reservationDto, Integer id) {
        return ReservationMapper.toReservationDto(
                reservationDao.update(
                        ReservationMapper.toReservation(
                                reservationDto), id));

    }

    public Boolean delete(ReservationDto reservationDto, Integer id) {
        return reservationDao.delete(
                ReservationMapper.toReservation(
                        reservationDto), id);

    }

    public List<ReservationDto> getAll() {
        return reservationDao.findAll()
                .stream()
                .map(ReservationMapper::toReservationDto)
                .collect(Collectors.toList());
    }
}
