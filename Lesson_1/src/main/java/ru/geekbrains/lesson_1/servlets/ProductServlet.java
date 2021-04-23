package ru.geekbrains.lesson_1.servlets;

import ru.geekbrains.lesson_1.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "water", 20));
        productList.add(new Product(2, "bread", 30));
        productList.add(new Product(3, "potato", 25));
        productList.add(new Product(4, "milk", 80));
        productList.add(new Product(5, "coffee", 280));
        productList.add(new Product(6, "ham", 350));
        productList.add(new Product(7, "butter", 65));
        productList.add(new Product(8, "chicken", 200));
        productList.add(new Product(9, "sugar", 30));
        productList.add(new Product(10, "salt", 20));
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        out.println("<html><body>");
        for(Product p:productList) {
            out.println("<table><tr>");
            out.println("<td>" + p.getId() + "</td> <td>" + p.getTitle() +
                        "</td><td>" + p.getCost() + "</td>");
            out.println("</tr></table>");
        }

        out.println("</html></body>");

    }

    }



