package org.eja.ordersclient.controller;

import org.eja.ordersclient.Messages;
import org.eja.ordersclient.PersistentDateState;

public class RefreshOrdersAction extends AbstractLibAction {

    public static RefreshOrdersAction instance = new RefreshOrdersAction();

    private RefreshOrdersAction() {
        super(Messages.Refresh_Orders.createMess());
    }

    @Override
    public void execute() {
        PersistentDateState.instance.dateChanged();
    }

}
