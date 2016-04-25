package org.eja.ordersclient.view;

import javafx.scene.control.Menu;
import org.eja.ordersclient.Messages;
import org.eja.ordersclient.controller.CreateOrderAction;
import org.eja.ordersclient.controller.RefreshOrdersAction;

public class OrdersMenu extends Menu {

    public OrdersMenu() {
        super(Messages.Orders.createMess());
        getItems().addAll(CreateOrderAction.instance.genMenuItem(),
                RefreshOrdersAction.instance.genMenuItem());
    }

}
