/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.data;

import bi.eja.orders.model.Address;
import bi.eja.orders.model.Benefit;
import bi.eja.orders.model.Customer;
import bi.eja.orders.model.Order;
import bi.eja.orders.model.VIPCustomer;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Named
public class CustomerDAO extends AbstractDAO<Customer, String> {

    @PersistenceContext
    EntityManager em;

    public CustomerDAO() {
        super(Customer.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Order> getOrders(String customerUsername) {
        Customer c = find(customerUsername);
        return c.getOrders();
    }

    public void addBenefit(String username, String description) {
        VIPCustomer c = findVIP(username);
        c.getBenefits().add(new Benefit(description));
    }

    public VIPCustomer findVIP(String username) {
        return em.find(VIPCustomer.class, username);
    }

}
