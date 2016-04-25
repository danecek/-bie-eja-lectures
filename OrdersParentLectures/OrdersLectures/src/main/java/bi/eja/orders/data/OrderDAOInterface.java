/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.data;

import bi.eja.orders.model.Order;
import java.util.List;
import javax.ejb.Lock;
import javax.ejb.LockType;

/**
 *
 * @author danecek
 */
public interface OrderDAOInterface {

    void create(Order o);

    void delete(Integer orderId);

    @Lock(value = LockType.READ)
    List<Order> getOrders();

    List<Order> ordersByCustomer(String customerUsername);

    void update(Order order);
    
}
