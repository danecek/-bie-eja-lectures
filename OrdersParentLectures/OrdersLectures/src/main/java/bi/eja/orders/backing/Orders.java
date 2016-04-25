package bi.eja.orders.backing;

import bi.eja.orders.data.OrderDAOInterface;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class Orders {

    @Inject
    OrderDAOInterface ordersDAO;

    public String delete(Integer orderId) {
        ordersDAO.delete(orderId);
        return "orders?faces-redirect=true";
    }

}
