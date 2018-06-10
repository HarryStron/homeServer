package com.harrys.resources;

import com.codahale.metrics.annotation.Timed;

import io.dropwizard.jersey.errors.ErrorMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Api(value="Admin Tools")
@Path("/adminTools")
@Produces(MediaType.APPLICATION_JSON)
public class AdminResource {
    @GET
    @Path("echo")
    @Timed
    @ApiOperation(value = "Echoes the string you pass it in")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Done", response = String.class),
            @ApiResponse(code = 404, message = "Name not found", response = ErrorMessage.class)
    })
    public String echo(@QueryParam("echo") String name) {
        if (name != null)
            return name;
        throw new NotFoundException();
    }
}
