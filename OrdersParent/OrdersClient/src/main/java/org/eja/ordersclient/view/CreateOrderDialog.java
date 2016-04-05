package org.eja.ordersclient.view;

import bi.eja.orders.model.Item;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import org.eja.ordersclient.Messages;
import org.eja.ordersclient.MyAlert;
import org.eja.ordersclient.PersistentDateState;
import org.eja.ordersclient.Proxy;

public class CreateOrderDialog extends AbstractLibDialog {

    ListView itemsList;
    private ToggleGroup group;

    public CreateOrderDialog() {
        super(Messages.Create_Order.createMess());
    }

    @Override
    protected Node createContent() {
        group = new ToggleGroup();
        VBox vbox = new VBox(5);
        for (Item i : Item.values()) {
            RadioButton button = new RadioButton(i.toString());
            button.setSelected(true);
            vbox.getChildren().add(button);
            button.setToggleGroup(group);
            button.setUserData(i);
        }
        return vbox;
    }

    @Override
    protected void ok() {
        try {
            Proxy.instance.createOrder(LoginPanel.instance.getUsername(),
                    (Item) group.getSelectedToggle().getUserData());
            PersistentDateState.instance.dateChanged();
        } catch (Exception ex) {
            Logger.getLogger(CreateOrderDialog.class.getName()).log(Level.SEVERE, null, ex);
            MyAlert.error(ex.toString());
        }
    }

    @Override
    public void validate() {

    }

}
