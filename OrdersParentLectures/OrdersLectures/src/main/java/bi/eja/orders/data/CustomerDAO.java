/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.data;

import bi.eja.orders.model.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Named
public class CustomerDAO implements CustomerDAOInterface {

    @PersistenceContext
    EntityManager em;

    @Override
    public void createCustomer(Customer cust) {
        em.persist(cust);
    }

    @Override
    public void delete(String customerUsername) {
        Customer c = find(customerUsername);
    //   for  c.getOrders();
        em.remove(c);
    }

    @Override
    public boolean exists(String customerUsername) {
        return find(customerUsername) != null;
    }

    @Override
    public Customer find(String username) {
        return em.find(Customer.class, username);
    }

    @Override
    public List<Customer> getCustomers() {
        return em.createNamedQuery("allcustomers", Customer.class).getResultList();
    }

}
