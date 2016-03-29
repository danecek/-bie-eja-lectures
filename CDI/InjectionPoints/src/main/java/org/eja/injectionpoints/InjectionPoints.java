/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eja.injectionpoints;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class InjectionPoints {

    @Inject
    private Bean bean1;
    private final Bean bean2;
    private Bean bean3;
    
    @Inject
    public InjectionPoints(Bean bean) {
        this.bean2 = bean;
    }

    @Produces
    static int orderProducer(Bean bean) {
        return bean.order;
    }

    @Inject
    void init(Bean bean) {
        this.bean3 = bean;
    }

    /**
     * @return the bean1
     */
    public Bean getBean1() {
        return bean1;
    }

    /**
     * @return the bean2
     */
    public Bean getBean2() {
        return bean2;
    }

    /**
     * @return the bean3
     */
    public Bean getBean3() {
        return bean3;
    }


}
