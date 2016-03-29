package org.eja.ejbannot;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Stateless
public class ClientBean {

    @EJB(beanName = "HelloBeanName")
    Hello helloBeanName;

    @EJB(lookup = "java:module/HelloBeanName!org.eja.ejbannot.Hello")
    Hello helloBeanGlobalName;

    @EJB(lookup = "java:module/HelloBeanName!org.eja.ejbannot.Bye")
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
            Hello hello = (Hello) new InitialContext().
                    lookup("java:module/HelloBeanName!org.eja.ejbannot.Hello");
            return hello.hello();
        } catch (NamingException ex) {
            return ex.toString();
        }

    }

}
