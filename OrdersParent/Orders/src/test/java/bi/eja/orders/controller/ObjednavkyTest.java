package bi.eja.orders.controller;

import bi.eja.orders.data.OrderDAO;
import org.junit.AfterClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.Assert;

public class ObjednavkyTest {

    private final static EJBContainer ejbContainer = EJBContainer.createEJBContainer();

    @Test
    public void oneInstancePerMultipleReferences() throws Exception {

        final Context context = ejbContainer.getContext();

        final OrderDAO one = (OrderDAO) context.lookup("java:global/Orders/Objednavky");
        one.clear();
        Assert.assertTrue(one.getOrders().isEmpty());
    }

    @AfterClass
    public static void closeEjbContainer() {
        ejbContainer.close();
    }
}
