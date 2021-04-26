package com.reservationsystem.controller;

import com.reservationsystem.dao.UserDao;
import com.reservationsystem.dto.UserDto;
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
    UserDao userDao;
    UserService userService;

    @POST
    public UserDto createUser(UserDto userDto) {
        return (userService.createUser(userDto));
    }

    @GET
    @Path("/{id}")
    public User readUser(@PathParam("id") Integer id) {
        return (userDao.read(id));
    }

    @PUT
    public UserDto updateUser(UserDto userDto, Integer id) {
        return (userService.updateUser(userDto, id));
    }

    @DELETE
    public Boolean deleteUser(UserDto userDto, Integer id) {
        return (userService.deleteUser(userDto, id));
    }
}
