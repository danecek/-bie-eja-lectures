package bi.eja.orders.backing;

import bi.eja.orders.data.CustomerDAO;
import bi.eja.orders.model.Address;
import bi.eja.orders.model.Customer;
import bi.eja.orders.model.VIPCustomer;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class CreateCustomer {

    private String username;
    private String address;
    private boolean vipCustomer;
    @Inject
    CustomerDAO customersDAO;

    public String add() {
        if (vipCustomer) {
            customersDAO.create(new VIPCustomer(username, new Address(address)));
        } else {
            customersDAO.create(new Customer(username, new Address(address)));
        }
        return "customers?faces-redirect=true";
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the vipCustomer
     */
    public boolean getVipCustomer() {
        return vipCustomer;
    }

    /**
     * @param vipCustomer the vipCustomer to set
     */
    public void setVipCustomer(boolean vipCustomer) {
        this.vipCustomer = vipCustomer;
    }



}
