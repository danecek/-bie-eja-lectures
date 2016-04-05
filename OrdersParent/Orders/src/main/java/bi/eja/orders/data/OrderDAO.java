package bi.eja.orders.data;

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
import javax.inject.Inject;

@Singleton
@ApplicationScoped
@Named
@DependsOn({"CustomerDAO"})
public class OrderDAO {

    private final Map<Integer, Order> orders = new HashMap<>();

    @Inject
    CustomerDAO customerDAO;

    @PostConstruct
    void init() {
        int c = 0;
        for (Customer cust : customerDAO.getCustomers()) {
            for (Item item : Item.values()) {
                create(new Order(cust.getUsername(), item, ++c));
            }
        }
    }

    public void create(Order o) {
        o.setId(orders.size() + 1);
        orders.put(o.getId(), o);
    }

    public void clear() {
        orders.clear();
    }

    @Lock(LockType.READ)
    public List<Order> getOrders() {
        return new ArrayList<>(orders.values());
    }

    public void update(Order order) {
        orders.put(order.getId(), order);
    }

    public void delete(Integer orderId) {
        orders.remove(orderId);
    }

    public List<Order> ordersByCustomer(String customerUsername) {
        List<Order> ords = new ArrayList<>();
        for (Order order : orders.values()) {
            if (order.getCustomerUsername().equals(customerUsername)) {
                ords.add(order);
            }
        }
        return ords;
    }

    public List<Order> getOrdersByUsername(String username) {
        List<Order> ords = new ArrayList<>();
        for (Order order : orders.values()) {
            if (order.getCustomerUsername().equals(username)) {
                ords.add(order);
            }
        }
        return ords;
    }

}
