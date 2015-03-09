/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author danecek
 */
public class Item {

    private final double value;
    private final int order;

    public Item(int order, double value) {
        this.value = value;
        this.order = order;

    }

    public double getValue() {
        return value;
    }

    public int getOrder() {
        return order;
    }

}
