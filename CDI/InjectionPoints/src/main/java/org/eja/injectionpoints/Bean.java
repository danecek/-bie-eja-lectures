/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eja.injectionpoints;

public class Bean {

    @Override
    public String toString() {
        return "Bean{" +  order + '}';
    }

    private static int counter;
    int order;

    public Bean() {
        order = counter++;
    }

}
