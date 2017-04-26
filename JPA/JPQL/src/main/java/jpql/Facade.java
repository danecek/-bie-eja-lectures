package jpql;

import static jpql.Status.*;
import java.util.List;
import java.util.logging.Logger;
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

    public Customer getTomByName() {
        Customer c = customerByName("Tom");
        return c;
    }

    public List<NameTown> getNameAddresses() {
        TypedQuery<NameTown> q = em.createNamedQuery("nameTowns", NameTown.class);
        return q.getResultList();
    }

    public List<StatusCount> getStatusCount() {
        TypedQuery<StatusCount> q = em.createNamedQuery("statuscounts", StatusCount.class);
        return q.getResultList();
    }

    public Customer getTomById() {
        Customer c = em.find(Customer.class, 1L);
        em.refresh(c);
        return c;
    }

    public List<Customer> getCustomers() {
        TypedQuery<Customer> q = em.createNamedQuery("customers", Customer.class);
        return q.getResultList();
    }

    private static final Logger LOG = Logger.getLogger(Facade.class.getName());

    public List<Order> getOrders() {
        TypedQuery<Order> q = em.createNamedQuery("ordersById", Order.class);
        q.setParameter(1, 1);
        return q.getResultList();
    }

    public Long ordersCount(long custId) {
        TypedQuery<Long> q = em.createNamedQuery("ordersCountById", Long.class);
        q.setParameter("custId", custId);
        return q.getSingleResult();
    }

    public Long getOrdersCount() {
        return ordersCount(1);
    }

    public Long getSumPrice() {
        TypedQuery<Long> q = em.createNamedQuery("sumOrdersPrice", Long.class);
        q.setParameter("custId", 1);
        return q.getSingleResult();
    }

    public Customer customerByName(String name) {
        TypedQuery<Customer> q = em.createNamedQuery("customerByName", Customer.class);
        q.setParameter("custName", name);
        Customer c = q.getSingleResult();
        c.orders.size();
        return c;
    }

    @PostConstruct
    public void init() {
        Customer c;
        em.persist(c = new Customer("Tom", new Address("Prague"), PLATINUM));
        em.persist(new Order(10, c));
        em.persist(new Order(20, c));
        em.persist(c = new Customer("Bob", new Address("NewYork"), GOLD));
        em.persist(new Order(10, c));
        em.persist(new Order(20, c));
    }

}
