/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.data;

import bi.eja.orders.model.Customer;
import java.util.List;

/**
 *
 * @author danecek
 */
public interface CustomerDAOInterface {

    void createCustomer(Customer cust);

    void delete(String customerUsername);

    boolean exists(String customerUsername);

    Customer find(String username);

    List<Customer> getCustomers();
    
}
