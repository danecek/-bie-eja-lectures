package bi.eja.orders.data.alternatives;

import bi.eja.orders.data.CustomerDAOInterface;
import bi.eja.orders.data.OrderDAOInterface;
import bi.eja.orders.model.Customer;
import bi.eja.orders.model.Item;
import bi.eja.orders.model.Order;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.inject.Named;
import javax.ejb.DependsOn;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

@Singleton
@ApplicationScoped
@Named
@DependsOn({"CustomerDAOSingleton"})
@Alternative
public class OrderDAOSingleton implements OrderDAOInterface {

    private final Map<Integer, Order> orders = new HashMap<>();

    @Inject
    CustomerDAOInterface customerDAO;

    @PostConstruct
    void init() {
        int c = 0;
        for (Customer cust : customerDAO.getCustomers()) {
            for (Item item : Item.values()) {
                create(new Order(cust, item, ++c));
            }
        }
    }

    @Override
    public void create(Order o) {
        o.setId(orders.size() + 1);
        orders.put(o.getId(), o);
    }

    @Lock(LockType.READ)
    @Override
    public List<Order> getOrders() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public void update(Order order) {
        orders.put(order.getId(), order);
    }

    @Override
    public void delete(Integer orderId) {
        orders.remove(orderId);
    }

    @Override
    public List<Order> ordersByCustomer(String customerUsername) {
        List<Order> ords = new ArrayList<>();
        for (Order order : orders.values()) {
            if (order.getCustomer().getUsername().equals(customerUsername)) {
                ords.add(order);
            }
        }
        return ords;
    }

}
