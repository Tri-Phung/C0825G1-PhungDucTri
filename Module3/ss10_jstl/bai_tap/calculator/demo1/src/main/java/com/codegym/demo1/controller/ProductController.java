package com.codegym.demo1.controller;

import com.codegym.demo1.entity.Product;
import com.codegym.demo1.service.IProductService;
import com.codegym.demo1.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productController", value = {"/products"})
public class ProductController extends HttpServlet {
    private final IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        List<Product> products;
        if (action == null) action = "list";
        switch (action) {
            case "list":
                products = productService.findAll();
                req.setAttribute("products", products);
                req.getRequestDispatcher("/WEB-INF/product/products-list.jsp").forward(req, resp);
                break;
            case "search":
                products = productService.findAllByName(req.getParameter("keyword"));
                req.setAttribute("products", products);
                req.getRequestDispatcher("/WEB-INF/product/products-list.jsp").forward(req, resp);
                break;
            case "detail":
                Integer id = Integer.parseInt(req.getParameter("id"));
                Product product = productService.findById(id);
                req.setAttribute("product", product);
                req.getRequestDispatcher("/WEB-INF/product/find-by-id.jsp").forward(req, resp);
                break;
            case "add":
                req.getRequestDispatcher("/WEB-INF/product/create-product.jsp").forward(req, resp);
                break;
            case "edit":
                Integer productId = Integer.parseInt(req.getParameter("id"));
                Product productToEdit = productService.findById(productId);
                req.setAttribute("product", productToEdit);
                req.getRequestDispatcher("/WEB-INF/product/update-product.jsp").forward(req, resp);
                break;
            case "delete":
                Integer productIdToDelete = Integer.parseInt(req.getParameter("id"));
                productService.delete(productIdToDelete);
                resp.sendRedirect(req.getContextPath() + "/products");
                break;
            default:
                products = productService.findAll();
                req.setAttribute("products", products);
                req.getRequestDispatcher("/WEB-INF/product/products-list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        switch (action) {
            case "create":
                String name = req.getParameter("name");
                double price = Double.parseDouble(req.getParameter("price"));
                int quantity = Integer.parseInt(req.getParameter("quantity"));
                String description = req.getParameter("description");
                Product product = new Product(null,name, price, quantity, description);
                productService.save(product);
                resp.sendRedirect(req.getContextPath() + "/products");
                break;
            case "update":
                Integer newProductId = Integer.parseInt(req.getParameter("id"));
                String newName = req.getParameter("name");
                double newPrice = Double.parseDouble(req.getParameter("price"));
                int newQuantity = Integer.parseInt(req.getParameter("quantity"));
                String newDescription = req.getParameter("description");
                Product productToUpdate = new Product(null,newName, newPrice, newQuantity, newDescription);
                productService.updateById(newProductId, productToUpdate);
                resp.sendRedirect(req.getContextPath() + "/products");
                break;
            default:
                resp.sendRedirect(req.getContextPath() + "/products");
        }
    }
}
