/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.backing;

import bi.eja.orders.data.OrderDAO;
import bi.eja.orders.data.OrderDAOInterface;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class Customers {

    @Inject
    private OrderDAOInterface orderDAO;

    /**
     * @return the orderDAO
     */
    public OrderDAOInterface getOrdersDAO() {
        return orderDAO;
    }
}
