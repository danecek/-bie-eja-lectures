/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eja.cdiinjection;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ReqScopedBean {

    private int order;
    static int counter;

    public ReqScopedBean() {
        this.order = counter++;
    }

    public int getOrder() {
        return order;
    }

}
