package com.reservationsystem.controller;

import com.reservationsystem.dto.UserDto;
import com.reservationsystem.model.Reservation;
import com.reservationsystem.model.UserRole;
import com.reservationsystem.service.UserService;

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
import java.util.ArrayList;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserService userService;

    @POST
    public UserDto createUser(UserDto userDto) {
        return(userService.createUser(userDto));
    }

    @GET
    @Path("/{id}")
    public UserDto readUser(@PathParam("id") Integer id) {
        return new UserDto(2, "asd", "fds",
                UserRole.USER, new ArrayList<Reservation>());
        //return(userService.readUser(id));
    }

    @PUT
    public UserDto updateUser(UserDto userDto, Integer id) {
        return(userService.updateUser(userDto, id));
    }

    @DELETE
    public Boolean deleteUser(UserDto userDto, Integer id) {
        return (userService.deleteUser(userDto, id));
    }
}
