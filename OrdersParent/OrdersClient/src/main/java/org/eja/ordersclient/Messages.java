/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eja.ordersclient;

/**
 *
 * @author danecek
 */
public enum Messages {

    Library, Error, Files, Exit, Id, Name, Item, Orders, Create_Order, Login, Refresh_Orders;

    public String createMess() {
        return this.name().replaceAll("_", " ");
    }
}
