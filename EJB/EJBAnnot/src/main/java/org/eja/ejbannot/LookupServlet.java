/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eja.ejbannot;

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
            out.println(cb.byName() + "<br/>");
            out.println(cb.globalNameHello() + "<br/>");
            out.println(cb.byLookup() + "<br/>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

}
