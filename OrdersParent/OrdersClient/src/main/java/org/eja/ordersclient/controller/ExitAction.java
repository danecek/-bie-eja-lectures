package org.eja.ordersclient.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eja.ordersclient.view.MainWindow;
import org.eja.ordersclient.Messages;

public class ExitAction extends AbstractLibAction {

    public static ExitAction instance = new ExitAction();

    private ExitAction() {
        super(Messages.Exit.createMess());
    }

    @Override
    public void execute() {
        try {
            MainWindow.instance.stop();
        } catch (Exception ex) {
            Logger.getLogger(ExitAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
