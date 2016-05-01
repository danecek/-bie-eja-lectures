package bi.eja.orders.data;

import bi.eja.orders.model.Order;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Named
public class OrderDAO extends AbstractDAO<Order, Integer> {

    @PersistenceContext
    EntityManager em;

    public OrderDAO() {
        super(Order.class);
    }

    public List<Order> ordersByCustomer(String customerUsername) {
        return em.createNamedQuery("ordersByCustomer", Order.class).
                setParameter(1, customerUsername).getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
