package bi.eja.orders.data.alternatives;

import bi.eja.orders.model.Customer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;

@Singleton
@ApplicationScoped
@Named
@Alternative
public class CustomerDAOSingleton {

    private final Map<String, Customer> customers = new HashMap<>();

    @PostConstruct
    void init() {
        createCustomer(new Customer("Tom"));
        createCustomer(new Customer("John"));
    }

    public Customer find(String username) {
        return customers.get(username);
    }


    public List<Customer> getCustomers() {
        return new ArrayList(customers.values());
    }

    public void createCustomer(Customer cust) {
        customers.put(cust.getUsername(), cust);
    }

    public void delete(String customerUsername) {
        customers.remove(customerUsername);
    }

    public boolean exists(String customerUsername) {
        return customers.containsKey(customerUsername);
    }

}
