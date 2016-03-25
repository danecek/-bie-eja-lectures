package org.eja.beanmanager;

import com.sun.webkit.InspectorClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.spi.Context;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {

    @Inject
    BeanManager beanManager;
    @Inject
    Instance<MyBean> inst;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>TestServlet</h1>");
            Set<Bean<?>> myBeanSet = beanManager.getBeans("myBean");
            out.print(myBeanSet + "<br/>");
            Context context = beanManager.getContext(RequestScoped.class);
            Bean<MyBean> myBeanBean = (Bean<MyBean>) myBeanSet.iterator().next();
            CreationalContext<MyBean> creationalContext = beanManager.createCreationalContext(myBeanBean);
            MyBean myBean1 = context.get(myBeanBean, creationalContext);
            out.print(myBean1 + "<br/>");
            MyBean myBean3 = context.get(myBeanBean);
            out.println(myBean3 + "<br/>");
            MyBean myBean2 = inst.get();
            out.println(myBean2 + "<br/>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

}
