package com.virtualpairprogrammers.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class HelloWorldServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><body><h1>Hello World!</h1>");
        out.println("<p>The time is: " + new Date() + "</p>");
        out.println("</html></body>");
        out.close();
    }

}
