package org.eja.stateful;

import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

@Stateful
public class DependentStatefulBean {

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
