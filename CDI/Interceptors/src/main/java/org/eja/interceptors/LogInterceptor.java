package org.eja.interceptors;

import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class LogInterceptor {

    private static final Logger LOG = Logger.getLogger(LogInterceptor.class.getName());

    @AroundInvoke
    Object c(InvocationContext ic) throws Exception {
        LOG.info(ic.getMethod().toString());
        return ic.proceed();

    }

}
