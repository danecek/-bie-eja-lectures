package org.eja.stateful;

import javax.ejb.Stateful;

@Stateful
public class StatefulBean {

    private int counter;

    public int count() {
        return ++counter;
    }


}
