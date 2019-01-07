package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.data.MenuDataService;
import com.virtualpairprogrammers.domain.MenuItem;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ViewMenuServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        MenuDataService menuDataService = new MenuDataService();
        List<MenuItem> menuItems = menuDataService.getFullMenu();

        out.println("<html><body><h1>Ricky's Restaurant</h1>");
        out.println("<h2>Menu</h2><ul>");
        out.println("<form action='/orderReceived.html' method='POST'>");

        for (MenuItem menuItem : menuItems) {
            out.println("<li><label>" + menuItem + "<input type='number' name='item_" + menuItem.getId() + "'/></label></li>");
        }

        out.println("<input type='submit'/>");
        out.println("</form>");
        out.println("</ul></body></html>");
        out.close();
    }

}
