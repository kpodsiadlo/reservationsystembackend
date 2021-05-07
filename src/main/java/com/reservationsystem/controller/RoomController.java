package com.reservationsystem.controller;

import com.reservationsystem.dto.RoomDto;
import com.reservationsystem.dto.RoomWithReservationsDto;
import com.reservationsystem.entity.Room;
import com.reservationsystem.service.RoomService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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

@RequestScoped
@Path("/room")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RoomController {

    @Inject
    RoomService roomService;

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

    @POST
    public RoomDto createRoom(Room room) {
        return (roomService.createRoom(room));
    }

    @PUT
    @Path("/{id}")
    public RoomDto updateRoom(Room room, @PathParam("id") Integer id) {
        return (roomService.updateRoom(room, id));
    }

    @DELETE
    @Path("/{id}")
    public Boolean deleteRoom(@PathParam("id") Integer id) {
        return (roomService.deleteRoom(id));
    }
}
