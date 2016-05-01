package bi.eja.orders.backing;

import bi.eja.orders.data.CustomerDAO;
import bi.eja.orders.data.OrderDAO;
import bi.eja.orders.model.Customer;
import bi.eja.orders.model.Item;
import bi.eja.orders.model.Order;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Model
public class CreateOrder {

    @Inject
    OrderDAO orderDAO;
    @Inject
    CustomerDAO customerDAO;
    private int quantity = 1;
    private Item item;
    private String customerUsername;
    private UIComponent mess;

    @PostConstruct
    void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        customerUsername = request.getParameter("customerUsername");
    }

    public Item[] getItems() {
        return Item.values();
    }

    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    public String createOrder() {
        Customer c = customerDAO.find(customerUsername);
        if (c != null) {
            orderDAO.create(new Order(c, item, quantity));
            return "orders";
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(getMess().getClientId(context), new FacesMessage("Unknown customer"));
            return null;
        }

    }

    /**
     * @return the customerUsername
     */
    public String getCustomerUsername() {
        return customerUsername;
    }

    /**
     * @param customerUsername the customerUsername to set
     */
    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    /**
     * @return the mess
     */
    public UIComponent getMess() {
        return mess;
    }

    /**
     * @param mess the mess to set
     */
    public void setMess(UIComponent mess) {
        this.mess = mess;
    }
}
