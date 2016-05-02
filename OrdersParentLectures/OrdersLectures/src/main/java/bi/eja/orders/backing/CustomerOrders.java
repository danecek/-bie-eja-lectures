package bi.eja.orders.backing;

import bi.eja.orders.data.CustomerDAO;
import bi.eja.orders.data.OrderDAO;
import bi.eja.orders.model.Order;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Model
public class CustomerOrders {

    @Inject
    OrderDAO orderDAO;
    @Inject
    CustomerDAO customerDAO;
    private String customerUsername;

    @PostConstruct
    void init() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().
                getExternalContext().getRequest();
        customerUsername = req.getParameter("customerUsername");
        //       ordersByCustomer = customerDAO.find(customerUsername).getOrders();//  orderDAO.fordersByCustomer(customerUsername);
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public List<Order> getOrdersByCustomer() {
        return customerDAO.getOrders(customerUsername);//  orderDAO.fordersByCustomer(customerUsername);
    }

}
