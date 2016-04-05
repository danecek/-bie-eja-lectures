/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eja.ordersclient.view;

import bi.eja.orders.model.Order;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import org.eja.ordersclient.ActionsState;
import org.eja.ordersclient.Messages;
import org.eja.ordersclient.MyAlert;
import org.eja.ordersclient.OrdersClientException;
import org.eja.ordersclient.PersistentDateState;
import org.eja.ordersclient.Proxy;

/**
 *
 * @author danecek
 */
public class OrderPanel extends TitledPane implements Observer {

    private static final Logger LOG = Logger.getLogger(OrderPanel.class.getName());
    ObservableList<Order> orders = FXCollections.observableArrayList();

    private final TableView<Order> table;

    private TableView<Order> createTable() {
        TableView<Order> table = new TableView<>();
        TableColumn<Order, String> idCol
                = new TableColumn<>(Messages.Id.createMess());
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Order, String> itemCol
                = new TableColumn<>(Messages.Item.createMess());
        itemCol.setCellValueFactory(new PropertyValueFactory<>("item"));
        table.getColumns().addAll(idCol, itemCol);
        table.setItems(orders);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.getSelectionModel().getSelectedItems().
                addListener(new ListChangeListener<Order>() {
                    @Override
                    public void onChanged(ListChangeListener.Change<? extends Order> changed) {
                        ActionsState.instance.dateChanged();
                    }
                });
        return table;
    }

    public OrderPanel() {
        super(Messages.Orders.createMess(), null);
        table = createTable();
        setContent(table);
        PersistentDateState.instance.addObserver(this);
    }

    public void refresh() throws OrdersClientException {
        List<Order> allOrders = Proxy.instance.get(LoginPanel.instance.getUsername());
        orders.clear();
        orders.addAll(allOrders);
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            refresh();
        } catch (OrdersClientException ex) {
            MyAlert.error(ex);
        }
    }

    public TableView<Order> getTable() {
        return table;
    }

    ObservableList<Order> selectedOrders() {
        return table.getSelectionModel().getSelectedItems();
    }

}
