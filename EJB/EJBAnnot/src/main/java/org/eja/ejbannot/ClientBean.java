package org.eja.ejbannot;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Stateless
public class ClientBean {

    @EJB(beanName = "HelloBeanName")
    Hello helloBeanName;

    @EJB(lookup = "java:global/GlobalHello")
    Hello helloBeanGlobalName;

    @EJB(lookup = "java:global/GlobalBye")
    Bye byeBeanGlobalName;

    public String byName() {
        return helloBeanName.hello();
    }

    public String globalNameHello() {
        return helloBeanGlobalName.hello();
    }

    public String globalNameBye() {
        return byeBeanGlobalName.bye();
    }

    public String byLookup() {
        try {
            Hello hello = (Hello) new InitialContext().lookup("java:global/GlobalHello");
            return hello.hello();
        } catch (NamingException ex) {
            return ex.toString();
        }

    }

}
