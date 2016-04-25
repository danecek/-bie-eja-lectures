/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eja.ordersclient.view;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 *
 * @author danecek
 */
public class LoginPanel extends HBox {

    private final TextField username;
    private final PasswordField password;
    
    public static final LoginPanel instance = new LoginPanel();

    private LoginPanel() {
        this.getChildren().addAll(
                new Label("username:"),
                username = new TextField(),
                new Label("password:"),
                password = new PasswordField()
        );
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username.getText();
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password.getText();
    }

}
