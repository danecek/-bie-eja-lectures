package org.eja.ordersclient.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eja.ordersclient.view.CreateOrderDialog;
import org.eja.ordersclient.Messages;

public class CreateOrderAction extends AbstractLibAction {

    public static CreateOrderAction instance = new CreateOrderAction();

    private CreateOrderAction() {
        super(Messages.Create_Order.createMess());
    }

    @Override
    public void execute() {
        try {
           new CreateOrderDialog().execute();
        } catch (Exception ex) {
            Logger.getLogger(CreateOrderAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
