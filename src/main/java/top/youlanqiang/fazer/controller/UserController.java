package top.youlanqiang.fazer.controller;


import org.pac4j.jax.rs.annotations.Pac4JSecurity;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
@Singleton
@Pac4JSecurity(authorizers = "hello")
public class UserController {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") Long id){
        return Response.status(200).entity("hello world").build();
    }
}
