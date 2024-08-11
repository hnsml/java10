package org.akaichi.servlets;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "task1Servlet", value = "/task-1-servlet")
public class Task1Servlet extends HttpServlet {
    private String message;

    public void init() {
        message = "\"Bad programmers worry about the code. Good programmers worry about data structures and their\n" +
                "relationships.\" - Linus Torvalds";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
