/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rest;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author danecek
 */
public class Proxy {

    public static final Proxy inst = new Proxy();
    public final static String ENDPOINT_ADDRESS = "http://localhost:8080/greeting";

    private final Response res;
    private final WebTarget personsResource;

    public Proxy() {
        Client c = ClientBuilder.newClient();
        personsResource = c.target(ENDPOINT_ADDRESS + "/persons");
        res = personsResource.request(MediaType.APPLICATION_XML).get();
    }

    public List<Person> persons() {
        List<Person> s = res.readEntity(new GenericType<List<Person>>() {
        });
        return s;
    }

    public Person persons(int id) {
        WebTarget personResource = personsResource.path(Integer.toString(id));
        Response pres = personResource.request(MediaType.APPLICATION_XML).get();
        return pres.readEntity(Person.class);
    }

}
