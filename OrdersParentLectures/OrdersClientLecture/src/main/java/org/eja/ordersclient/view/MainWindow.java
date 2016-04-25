/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eja.ordersclient.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.eja.ordersclient.Messages;
import org.eja.ordersclient.MyAlert;
import org.eja.ordersclient.OrdersClientException;

/**
 *
 * @author danecek
 */
public class MainWindow extends Application {

    public static MainWindow instance;

    private MenuBar libMenuBar;
    private OrderPanel readerPanel;
    Stage primaryStage;
    LoginPanel loginPanel;

    public void ordersStop() {
        primaryStage.close();
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        instance = this;
        primaryStage.setTitle(Messages.Library.createMess());
//        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//
//            @Override
//            public void handle(WindowEvent event) {
//                try {
//                    ordersStop();
//                } catch (Exception ex) {
//                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
        libMenuBar = new MenuBar(new FilesMenu(), new OrdersMenu());
        readerPanel = new OrderPanel();
        HBox top = new HBox(10, libMenuBar, LoginPanel.instance);

        VBox root = new VBox(10, top, readerPanel);
        Scene s = new Scene(root, 800, 600);
        primaryStage.setScene(s);
        primaryStage.show();
        try {
            refresh();
        } catch (OrdersClientException ex) {
            MyAlert.error(ex);
        }
    }

    /**
     * @return the libMenuBar
     */
    public MenuBar getLibMenuBar() {
        return libMenuBar;
    }

    public void refresh() throws OrdersClientException {
        readerPanel.refresh();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
