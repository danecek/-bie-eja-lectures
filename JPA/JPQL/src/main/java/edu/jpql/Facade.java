package edu.jpql;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Named
@Singleton
public class Facade {

    @PersistenceContext
    EntityManager em;

    public Customer getCustomer() {
        TypedQuery<Customer> q = em.createNamedQuery("customer", Customer.class);
        q.setParameter("custId", 1);
        return q.getSingleResult();
    }

    public List<Customer> getCustomers() {
        TypedQuery<Customer> q = em.createNamedQuery("customers", Customer.class);
        return q.getResultList();
    }

    public List<CustomerOrder> getOrders() {
        TypedQuery<CustomerOrder> q = em.createNamedQuery("orders", CustomerOrder.class);
        q.setParameter(1, 1);
        return q.getResultList();
    }

    public Long getOrdersCount() {
        TypedQuery<Long> q = em.createNamedQuery("ordersCount", Long.class);
        q.setParameter("custId", 1);
        return q.getSingleResult();
    }

    public Long getSumPrice() {
        TypedQuery<Long> q = em.createNamedQuery("sumOrdersPrice", Long.class);
        q.setParameter("custId", 1);
        return q.getSingleResult();
    }

    @PostConstruct
    public void init() {
        Customer c;
        em.persist(c = new Customer("Tom"));
        em.persist(new CustomerOrder(10, c));
        em.persist(new CustomerOrder(20, c));
    }

}
