package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.data.MenuDataService;
import com.virtualpairprogrammers.domain.MenuItem;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

public class MenuItemServlet extends HttpServlet {


    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        MenuDataService menuDataService = new MenuDataService();
        List<MenuItem> menuItems = menuDataService.getFullMenu();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><body><h1>Menu Items!</h1>");
        out.println("<ul>");
        for (MenuItem menuItem : menuItems) {
            out.println("<li>" + menuItem.toString() + "</li>");
        }
        out.println("<ul>");
        out.println("<p>The time is: " + new Date() + "</p>");
        out.println("</html></body>");
        out.close();
    }

}
