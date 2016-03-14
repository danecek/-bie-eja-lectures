package org.lib.servlethw;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloWorldServlet", urlPatterns = {"/HelloWorldServlet"})
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (ServletOutputStream out = response.getOutputStream()) {
            byte[] header = "<!DOCTYPE html>".getBytes();
                        out.write(header);
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>".t);
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet HelloWorldServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.flush();
////            out.println("<h1>Servlet HelloWorldServlet</h1>");
//            byte [] bts = {32,65,66};
//            out.write(bts);
//           //  out.println(0x40);
//            out.println("</body>");
//            out.println("</html>");
        }
    }


}
