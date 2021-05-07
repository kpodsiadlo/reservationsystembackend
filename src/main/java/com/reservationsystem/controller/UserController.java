package com.reservationsystem.controller;

import com.reservationsystem.dto.UserDto;
import com.reservationsystem.dto.UserWithReservationsDto;
import com.reservationsystem.entity.User;
import com.reservationsystem.service.UserService;

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
@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserService userService;

    @POST
    public User createUser(User user) {
        return (userService.createUser(user));
    }

    @GET
    @Path("/{id}")
    public UserDto readUser(@PathParam("id") Integer id) {
        return (userService.readUser(id));
    }

    @GET
    @Path("withreservations/{id}")
    public UserWithReservationsDto readUserWithReservations(@PathParam("id") Integer id) {
        return (userService.readUserWithReservations(id));
    }

    @PUT
    public User updateUser(User user, Integer id) {
        return (userService.updateUser(user, id));
    }

    @DELETE
    public Boolean deleteUser(User user, Integer id) {
        return (userService.deleteUser(user, id));
    }
}
