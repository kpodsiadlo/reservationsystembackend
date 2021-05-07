package com.reservationsystem.controller;

import com.reservationsystem.dto.IncomingReservationDto;
import com.reservationsystem.dto.ReservationDto;
import com.reservationsystem.dto.ReservationWithRoomDto;
import com.reservationsystem.entity.Reservation;
import com.reservationsystem.service.ReservationService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Transactional
@RequestScoped
@Path("/reservation")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReservationController {

    @Inject
    ReservationService reservationService;

    @GET
    @Path("/{id}")
    public ReservationDto readReservation(@PathParam("id") Integer id) {
        return (reservationService.readReservation(id));
    }

    @POST
    public ReservationWithRoomDto createReservation(IncomingReservationDto incomingReservationDto) {
        return (reservationService.createReservation(incomingReservationDto));
    }

    @PUT
    @Path("/{id}")
    public ReservationWithRoomDto updateReservation(Reservation reservation,
                                                    @PathParam("id") Integer id) {
        return (reservationService.updateReservation(reservation, id));
    }

    @DELETE
    @Path("/{id}")
    public Boolean deleteReservation(@PathParam("id") Integer id) {
        return (reservationService.deleteReservation( id));
    }
}
