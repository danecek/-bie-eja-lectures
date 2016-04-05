package org.eja.ordersclient.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eja.ordersclient.view.CreateOrderDialog;
import org.eja.ordersclient.view.MainWindow;
import org.eja.ordersclient.Messages;

public class LoginAction extends AbstractLibAction {

    public static LoginAction instance = new LoginAction();

    private LoginAction() {
        super(Messages.Login.createMess());
    }

    @Override
    public void execute() {
        try {
           new CreateOrderDialog().execute();
        } catch (Exception ex) {
            Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
