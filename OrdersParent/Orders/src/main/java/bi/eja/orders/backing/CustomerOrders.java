package bi.eja.orders.backing;

import bi.eja.orders.data.OrderDAO;
import bi.eja.orders.model.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Model
public class CustomerOrders {

    @Inject
    OrderDAO ordersDAO;
    private String customerUsername;
    private List<Order> ordersByCustomer;

    @PostConstruct
    void init() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().
                getExternalContext().getRequest();
        customerUsername = req.getParameter("customerUsername");
        ordersByCustomer = ordersDAO.ordersByCustomer(customerUsername);
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public List<Order> getOrdersByCustomer() {
        return ordersByCustomer;
    }

    public void setOrdersByCustomer(List<Order> ordersByCustomer) {
        this.ordersByCustomer = ordersByCustomer;
    }

}
