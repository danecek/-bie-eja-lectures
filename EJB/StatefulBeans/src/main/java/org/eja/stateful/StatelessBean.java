/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eja.stateful;

import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless
public class StatelessBean {

    static final int MOD = 100;

    private int counter;

    @PostConstruct
    void init() {
        counter = new Random().nextInt(MOD);
    }

    public int state() {
        counter = (counter + 1) % MOD;
        return counter;
    }

}
