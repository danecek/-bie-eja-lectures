/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.backing;

import bi.eja.orders.data.CustomerDAO;
import bi.eja.orders.model.Customer;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class AddCustomer {

    private String username;
    @Inject
    CustomerDAO customersDAO;

    public String add() {
        customersDAO.createCustomer(new Customer(username));
        return "customers?faces-redirect=true";
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

}
