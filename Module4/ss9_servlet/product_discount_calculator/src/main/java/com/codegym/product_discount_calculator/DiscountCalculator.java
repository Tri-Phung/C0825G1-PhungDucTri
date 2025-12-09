package com.codegym.product_discount_calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "discountCalculator", value = "/discount-calculator")
public class DiscountCalculator extends HttpServlet {
    String message = "";

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            String productDescription = req.getParameter("productDescription");
            double listPrice = Double.parseDouble(req.getParameter("listPrice"));
            double discountPercent = Double.parseDouble(req.getParameter("discountPercent"));
            double discountAmount = listPrice * discountPercent / 100;
            double discountPrice = listPrice - discountAmount;
            req.setAttribute("productDescription", productDescription);
            req.setAttribute("listPrice", listPrice);
            req.setAttribute("discountPercent", discountPercent);
            req.setAttribute("discountAmount", discountAmount);
            req.setAttribute("discountPrice", discountPrice);
            req.getRequestDispatcher("/result.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            message = "Invalid input";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
    public void destroy() {
    }
}
