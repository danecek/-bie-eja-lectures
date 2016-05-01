package bi.eja.orders.backing;

import bi.eja.orders.data.OrderDAO;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class Orders {

    @Inject
    OrderDAO ordersDAO;

    public String delete(Integer orderId) {
        ordersDAO.delete(orderId);
        return "orders?faces-redirect=true";
    }

}
