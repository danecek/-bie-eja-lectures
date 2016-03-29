package org.eja.stateful;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ClientBean {

    @Inject
    StatefulBean sfb1;

    public int x() {
        return sfb1.count();
    }
    @Inject
    StatefulBean sfb2;
    @Inject
    SessionScopedStatefulBean rssf1;
    @Inject
    SessionScopedStatefulBean rssf2;

}
