package com.codegym.demo;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "index", value = "/translate")
public class HelloServlet extends HttpServlet {
    public void init() {
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "xin chao");
        dictionary.put("bye","tam biet");
        String text = request.getParameter("txtSearch");
        String result = dictionary.get(text);
        if (result == null) {
            request.setAttribute("message", "Khong tim thay");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        request.setAttribute("text", text);
        request.setAttribute("result", result);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}