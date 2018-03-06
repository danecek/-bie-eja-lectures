/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class PersonSubresource {

    int id;

    PersonSubresource(int id) {
        this.id = id;
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Person get() {
        return PersonsDB.inst.persons.get(id);
    }
}
