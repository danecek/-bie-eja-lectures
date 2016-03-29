package org.eja.stateful;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

@Stateful
@SessionScoped
public class SessionScopedStatefulBean {

    int counter;

    public int count() {
        return ++counter;
    }

}
