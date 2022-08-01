//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String hello() {
//        return "Hello from RESTEasy Reactive";
//    }

package org.redhat.tdd;

import org.redhat.tdd.GreetingResourceService;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/tdd")
public class GreetingResource {
    @Inject
    GreetingResourceService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> getAll() {
        return service.getAllItems();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getOne(@PathParam("id") Long id) {
        return service.getItem(id)
                .map(item -> Response.ok(item).build())
                .orElseGet(() -> Response.status(Status.NOT_FOUND).build());
    }
}