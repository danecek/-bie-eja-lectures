/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eja.stateful;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ClientServlet", urlPatterns = {"/ClientServlet"})
public class ClientServlet extends HttpServlet {

//    @Inject
//    ClientBean cb;
    @Inject
    StatefulBean sfb1;
    @Inject
    StatefulBean sfb2;
    @Inject
    SessionScopedStatefulBean rssf1;
    @Inject
    SessionScopedStatefulBean rssf2;

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
            out.println("<h1>ClientServlet</h1>");
               out.println("ID:" + request.getSession().getId()+ "<br/>");
//            out.println(cb.x() + "<br/>");
            out.println(sfb1.count() + "<br/>");
            out.println(sfb2.count() + "<br/>");
            out.println(sfb1.equals(sfb2) + "<br/>");
            out.println(rssf1.count() + "<br/>");
            out.println(rssf2.count() + "<br/>");
            out.println(rssf1.equals(rssf2) + "<br/>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

}
