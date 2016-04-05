/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.controller;

import bi.eja.orders.data.OrderDAO;
import bi.eja.orders.model.Order;
import javax.inject.Inject;
import javax.ws.rs.PUT;

public class ItemSubresource {

    @Inject
    OrderDAO orders;
    int id;

    public ItemSubresource(int id, OrderDAO orders) {
        this.id = id;
        this.orders = orders;
    }

    @PUT
    public void put(Order order) {
        orders.update(order);
    }

}
