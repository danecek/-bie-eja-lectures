package org.eja.qualifiers;

import javax.inject.Inject;
import javax.inject.Named;

public class InjectionPoints {

    public InjectionPoints() {
    }

    @Inject
    @Named("xxx")
    public Bean bean;
}
