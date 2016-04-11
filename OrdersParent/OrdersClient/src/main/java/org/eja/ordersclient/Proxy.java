/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eja.ordersclient;

import bi.eja.orders.model.Item;
import bi.eja.orders.model.Order;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Proxy {

    public static final Proxy instance = new Proxy();
    private final WebTarget ordersResource;
    URI rootURI;
    Client client;

    private Proxy() {
        try {
            rootURI = new URI("http://localhost:8080/Orders/webresources/orders");
        } catch (URISyntaxException ex) {
            Logger.getLogger(Proxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        client = ClientBuilder.newClient();
        ordersResource = client.target(rootURI);
        ordersResource.register(new LoginFilter());
    }

    public List<Order> get(String username) throws OrdersClientException {
        try {
            return ordersResource.queryParam("username", username).
                    request(MediaType.APPLICATION_XML).
                    get(new GenericType<List<Order>>() {
                    });
        } catch (Exception ex) {
            throw new OrdersClientException(ex);
        }
    }

    public void createOrder(String username, Item item) throws OrdersClientException {
        try {
            Response r = ordersResource.request().put(null);
            URI location = r.getLocation();
            int newId = Integer.parseInt(rootURI.relativize(location).toString());
            WebTarget newOrderResource = client.target(location);// ordersResource.path(Integer.toString(newId));
            newOrderResource.request().put(Entity.xhtml(new Order(newId, username, item, 1)));
        } catch (WebApplicationException ex) {
            throw new OrdersClientException(ex);
        }
    }

}
