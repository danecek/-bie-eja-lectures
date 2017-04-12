package org.eja.stateful;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClientServlet", urlPatterns = {"/ClientServlet"})
public class ClientServlet extends HttpServlet {

    @Inject
    DependentStatefulBean dependentStatefulBeanA;
    @Inject
    DependentStatefulBean dependentStatefulBeanB;
    @Inject
    SessionScopedStatefulBean sessionScopedStatefulBeanA;
    @Inject
    SessionScopedStatefulBean sessionScopedStatefulBeanB;
    @Inject
    private StatelessBean statelessBean;

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
            out.println("<title>Servlet ClientServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Stateful Beans</h1>");
            out.println("<h2>Session ID:" + request.getSession().getId() + "</h2>");
            out.println("<table border =\"1\"><tr>");
            out.println("<td>Stateless bean</td><td> " + statelessBean.state() + "</td>");
            out.println("</tr> <tr>");
            out.println("<td>Dependent stateful bean A</td><td> " + dependentStatefulBeanA.state() + "</td>");
            out.println("</tr> <tr>");
            out.println("<td>Dependent stateful bean B</td><td>  " + dependentStatefulBeanB.state() + "</td>");
            out.println("</tr> <tr>");
            out.println("<td>Equality of A and B</td><td> " + dependentStatefulBeanA.equals(dependentStatefulBeanB) + "</td>");
            out.println("</tr> <tr>");
            out.println("<td>Sessionscoped stateful bean C</td><td> " + sessionScopedStatefulBeanB.state() + "</td>");
            out.println("</tr> <tr>");
            out.println("<td>Sessionscoped stateful bean D</td><td> " + sessionScopedStatefulBeanA.state() + "</td>");
            out.println("</tr> <tr>");
            out.println("<td>Equality of C and D: </td><td> " + sessionScopedStatefulBeanB.equals(sessionScopedStatefulBeanA) + "</td>");
            out.println("</tr> </table>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

}
