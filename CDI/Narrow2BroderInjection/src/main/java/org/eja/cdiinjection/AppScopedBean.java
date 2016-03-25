/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eja.cdiinjection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AppScopedBean {

    @Inject
    ReqScopedBean rsb;
    
    public int rsbOrder() {
      return rsb.getOrder();
    }
    
}
