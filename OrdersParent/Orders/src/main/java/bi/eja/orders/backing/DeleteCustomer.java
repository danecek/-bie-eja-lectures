/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.backing;

import bi.eja.orders.data.CustomerDAO;
import bi.eja.orders.model.Customer;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Model
public class DeleteCustomer {

    private Customer customer;
    @Inject
    CustomerDAO customersDAO;

    @PostConstruct
    public void init() {
        ExternalContext sc = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest req = (HttpServletRequest) sc.getRequest();
        String customerUsername = req.getParameter("customerUsername");
        setCustomer(customersDAO.find(customerUsername));
    }

    public String delete() {
        customersDAO.delete(customer.getUsername());
        return "customers";
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
