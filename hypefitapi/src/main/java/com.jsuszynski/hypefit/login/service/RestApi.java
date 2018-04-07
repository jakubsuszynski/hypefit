package com.jsuszynski.hypefit.login.service;


import com.jsuszynski.hypefit.login.domain.Credentials;
import com.jsuszynski.hypefit.login.domain.User;
import com.jsuszynski.hypefit.login.repository.UsersRepository;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Path("/")
public class RestApi {
    @Inject
    private UsersRepository usersRepository;

    @POST
    @Path("authenticate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticate(Credentials credentials) {
        Optional<User> user = Optional.ofNullable(usersRepository.authenticate(credentials));
        if (user.isPresent()) {
            return Response.ok(user.get()).build();
        }
        return Response.status(NOT_FOUND).build();
    }

    @POST
    @Path("register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(User user) {
        usersRepository.register(user);
        return Response.ok().build();

    }
}
