package bi.eja.orders.backing;

import bi.eja.orders.data.CustomerDAO;
import bi.eja.orders.model.Address;
import bi.eja.orders.model.Customer;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Model
public class UpdateCustomer {
    
    private Customer customer;
 //   private String address;
    @Inject
    CustomerDAO customerDAO;
    
    @PostConstruct
    public void init() {
        ExternalContext sc = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest req = (HttpServletRequest) sc.getRequest();
        String customerUsername = req.getParameter("customerUsername");
        setCustomer(customerDAO.find(customerUsername));
    }
    
    public String update() {
       // customer.setAddress(new Address(address));
        customerDAO.update(customer);
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

//    /**
//     * @return the address
//     */
//    public String getAddress() {
//        return address;
//    }
//
//    /**
//     * @param address the address to set
//     */
//    public void setAddress(String address) {
//        this.address = address;
//    }
    
}
