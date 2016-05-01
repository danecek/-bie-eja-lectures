package bi.eja.orders.controller;

import bi.eja.orders.data.OrderDAO;
import bi.eja.orders.model.Order;
import javax.ws.rs.PUT;

public class ItemSubresource {

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
