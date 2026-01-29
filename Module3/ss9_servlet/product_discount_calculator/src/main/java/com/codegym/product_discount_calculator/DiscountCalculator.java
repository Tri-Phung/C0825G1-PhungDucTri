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

        req.setCharacterEncoding("UTF-8");
        String productDescription = req.getParameter("productDescription");
        String inputListPrice = req.getParameter("listPrice");
        String inputDiscountPercent = req.getParameter("discountPercent");
        if (!Validate.inputStringNotEmpty(productDescription)) {
            message = "Please type something in the product description field";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        if (!Validate.inputDoublePrice(inputListPrice)) {
            message = "Price must be a positive number";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        if (!Validate.inputDoubleDiscount(inputDiscountPercent)) {
            message = "Discount must be a positive number between 0 and 100";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        double listPrice = Double.parseDouble(inputListPrice);
        double discountPercent = Double.parseDouble(inputDiscountPercent);
        double discountAmount = listPrice * discountPercent / 100;
        double discountPrice = listPrice - discountAmount;
        req.setAttribute("productDescription", productDescription);
        req.setAttribute("listPrice", listPrice);
        req.setAttribute("discountPercent", discountPercent);
        req.setAttribute("discountAmount", discountAmount);
        req.setAttribute("discountPrice", discountPrice);
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }

    public void destroy() {
    }
}
