package org.rest;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/persons")
public class PersonsResource {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> message() {
        return new ArrayList<>(PersonsDB.inst.persons.values());
    }

    @Path("{id}")
    public PersonSubresource pr(@PathParam("id") int id) {
        return new PersonSubresource(id);
    }

}
