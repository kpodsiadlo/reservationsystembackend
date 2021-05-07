package com.reservationsystem.controller;

import com.reservationsystem.dto.ReservationDto;
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

    @POST
    public ReservationDto createReservation(ReservationDto reservationDto) {
        return (reservationService.createReservation(reservationDto));
    }

    @GET
    @Path("/{id}")
    public ReservationDto readReservation(@PathParam("id") Integer id) {
        return (reservationService.readReservation(id));
    }

    @PUT
    public ReservationDto updateReservation(ReservationDto reservationDto, Integer id) {
        return (reservationService.updateReservation(reservationDto, id));
    }

    @DELETE
    public Boolean deleteReservation(ReservationDto reservationDto, Integer id) {
        return (reservationService.deleteReservation(reservationDto, id));
    }
}
