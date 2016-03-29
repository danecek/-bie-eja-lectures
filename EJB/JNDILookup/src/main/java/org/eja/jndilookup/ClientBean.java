/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eja.jndilookup;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author danecek
 */
@Stateless
public class ClientBean {

    @Inject
    HelloBean helloBean;

    public String byInject() {
        return helloBean.hello();
    }
    @EJB(beanName = "XXX")
    HelloBean helloBeanEJB;

    public String byEJB() {
        return helloBeanEJB.hello();
    }

    public String byLookup() {
        try {
            InitialContext ic = new InitialContext();
            HelloBean sb = (HelloBean) ic.lookup("java:module/HelloBean");
            return sb.hello();
        } catch (NamingException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Resource
    SessionContext sc;

    public String bySessionContext() {
        HelloBean sb = (HelloBean) sc.lookup("java:module/HelloBean");
        return sb.hello();

    }

}
