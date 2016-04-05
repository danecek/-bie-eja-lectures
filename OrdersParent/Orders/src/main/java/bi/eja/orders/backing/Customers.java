/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.backing;

import bi.eja.orders.data.OrderDAO;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class Customers {

    @Inject
    private OrderDAO ordersDAO;

    /**
     * @return the ordersDAO
     */
    public OrderDAO getOrdersDAO() {
        return ordersDAO;
    }
}
