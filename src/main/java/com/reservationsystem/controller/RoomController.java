package com.reservationsystem.controller;

import com.reservationsystem.dto.RoomDto;
import com.reservationsystem.dto.RoomWithReservationsDto;
import com.reservationsystem.service.RoomService;

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
import java.util.List;

@Transactional
@RequestScoped
@Path("/room")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RoomController {

    @Inject
    RoomService roomService;

    @POST
    public RoomDto createRoom(RoomDto roomDto) {
        return (roomService.createRoom(roomDto));
    }

    @GET
    @Path("/{id}")
    public RoomDto readRoom(@PathParam("id") Integer id) {
        return (roomService.readRoom(id));
    }

    @GET
    @Path("/full/{id}")
    public RoomWithReservationsDto readRoomWithReservations(@PathParam("id") Integer id) {
        return (roomService.readRoomWithReservations(id));
    }

    @GET
    public List<RoomDto> getAll() {
        return roomService.getAll();
    }

    @PUT
    public RoomDto updateRoom(RoomDto roomDto, Integer id) {
        return (roomService.updateRoom(roomDto, id));
    }

    @DELETE
    public Boolean deleteRoom(RoomDto roomDto, Integer id) {
        return (roomService.deleteRoom(roomDto, id));
    }
}