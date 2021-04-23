package ru.geekbrains.lesson_1.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="ProductFormServlet", urlPatterns = "/product_form")
public class ProductFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
            resp.setContentType("text/html");

            String idParam = req.getParameter("id");
            String titleParam = req.getParameter("title");
            String costParam = req.getParameter("cost");

        if (idParam==null || titleParam== null || costParam== null){
               resp.sendError(400, "The form can’t be empty");
               return;
            }
            out.println("<html><body>");
            out.println("<h1>  hello you </h1>");
            out.println("<table><tr><td>" + idParam + "</td> <td>" + titleParam +
                        "</td><td>" + costParam + "</td></tr></table>");
            out.println("<table><table><tr><td>" + idParam + "</td> <td>" + titleParam +
                "</td><td>" + costParam + "</td></tr></table>");
            resp.getWriter().println("</body></html>");
    }
}
