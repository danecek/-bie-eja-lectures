package org.eja.ordersclient;

import javafx.scene.control.Alert;

public class MyAlert {

    public static void error(Exception ex) {
        error(
    //            ex.toString() + "\n" + 
                        ex.getCause().toString());
    }

    public static void error(String mess) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText(mess);
        a.showAndWait();
    }
}
