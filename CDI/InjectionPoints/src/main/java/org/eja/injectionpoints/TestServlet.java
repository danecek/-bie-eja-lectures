/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eja.injectionpoints;

import java.io.IOException;
import java.io.PrintWriter;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danecek
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {

    @Inject
    InjectionPoints ic;
    @Inject
    int order;
    @Inject
    BeanManager bm;

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
            out.println("<h1>TestServlet </h1>");
            out.print(ic.getBean1() + "<br/>");
            out.print(ic.getBean2() + "<br/>");
            out.print(ic.getBean3() + "<br/>");
            out.print(order + "<br/>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

}
