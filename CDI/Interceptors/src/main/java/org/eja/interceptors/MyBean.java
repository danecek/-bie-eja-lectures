/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eja.interceptors;

import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

//@Interceptors(MyInterceptor.class)
//@NewInterceptor
public class MyBean {

    private static final Logger LOG = Logger.getLogger(MyBean.class.getName());

    @AroundInvoke
    Object log(InvocationContext ic) throws Exception {
        LOG.info(ic.getMethod().getName());
        return ic.proceed();
    }

    public String businessMethod1() {
        return "m1";
    }

    public String businessMethod2() {
        return "m2";
    }

}
