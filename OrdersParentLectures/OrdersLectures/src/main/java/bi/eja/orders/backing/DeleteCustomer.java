package bi.eja.orders.backing;

import bi.eja.orders.data.CustomerDAO;
import bi.eja.orders.model.Customer;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Model
public class DeleteCustomer {

    private Customer customer;
    @Inject
    CustomerDAO customerDAO;

    @PostConstruct
    public void init() {
        ExternalContext sc = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest req = (HttpServletRequest) sc.getRequest();
        String customerUsername = req.getParameter("customerUsername");
        setCustomer(customerDAO.find(customerUsername));
    }

    public String delete() {
        customerDAO.delete(customer.getUsername());
        return "customers";
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
