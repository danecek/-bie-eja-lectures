/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eja.jndilookup;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danecek
 */
@WebServlet(name = "LookupServlet", urlPatterns = {"/LookupServlet"})
public class LookupServlet extends HttpServlet {

    @Inject
    ClientBean cb;

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
            out.println("<title>Servlet LookupServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>LookupServlet</h1>");
            out.println(cb.byInject() + "<br/>");
            out.println(cb.byLookup() + "<br/>");
            out.println(cb.bySessionContext() + "<br/>");
            out.println(cb.byEJB() + "<br/>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

}
