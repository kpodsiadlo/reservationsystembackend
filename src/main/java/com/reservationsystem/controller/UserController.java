package com.reservationsystem.controller;

import com.reservationsystem.dto.UserDto;
import com.reservationsystem.dto.UserWithReservationsDto;
import com.reservationsystem.entity.User;
import com.reservationsystem.mapper.UserMapper;
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
import java.util.List;

@Transactional
@RequestScoped
@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserService userService;

    @POST
    public UserDto createUser(User user) {
        return UserMapper.toUserDto(userService.createUser(user));
    }

    @GET
    @Path("/{id}")
    public UserDto readUser(@PathParam("id") Integer id) {
        return (userService.readUser(id));
    }

    @GET
    @Path("full/{id}")
    public UserWithReservationsDto readUserWithReservations(@PathParam("id") Integer id) {
        return (userService.readUserWithReservations(id));
    }

    @GET
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @PUT
    @Path("/{id}")
    public UserDto updateUser(User user, @PathParam("id") Integer id) {
        return (userService.updateUser(user, id));
    }

    @DELETE
    @Path("/{id}")
    public Boolean deleteUser(@PathParam("id") Integer id) {
        return (userService.deleteUser(id));
    }
}
