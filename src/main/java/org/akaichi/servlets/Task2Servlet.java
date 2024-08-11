package org.akaichi.servlets;

import java.io.*;
import java.util.Objects;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "task2Servlet", value = "/task-2-servlet")
public class Task2Servlet extends HttpServlet {

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body><form action='task-2-servlet' method='post'>");
        out.println("<input name='i1'></input>");
        out.println("<input name='i2'></input>");
        out.println("<input name='i3'></input>");
        out.println("<p></p>");
        out.println("<input type='radio' name='action' value='max'>Максимальне число</input>");
        out.println("<input type='radio' name='action' value='average'>Середнє арифметичне</input>");
        out.println("<input type='radio' name='action' value='min'>Мінімальне число</input>");
        out.println("<input type='submit'></input>");
        out.println("<form></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double[] nums = {
            Double.parseDouble(req.getParameter("i1").replace(',', '.')),
            Double.parseDouble(req.getParameter("i2").replace(',', '.')),
            Double.parseDouble(req.getParameter("i3").replace(',', '.'))
        };
        String action = req.getParameter("action");

        double result = 0;

        if(Objects.equals(action, "max"))
        {
            for (double num : nums)
            {
                if (num > result)
                {
                    result = num;
                }
            }
        }
        else if(Objects.equals(action, "average"))
        {
            for(double num : nums)
            {
                result+=num;
            }
            result/= nums.length;
        }
        else if(Objects.equals(action, "min"))
        {
            result = nums[0];
            for (double num : nums)
            {
                if (num < result)
                {
                    result = num;
                }
            }
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body><form action='task-2-servlet' method='post'>");
        out.println("<input name='i1'></input>");
        out.println("<input name='i2'></input>");
        out.println("<input name='i3'></input>");
        out.println("<p></p>");
        out.println("<input type='radio' name='action' value='max'>Максимальне число</input>");
        out.println("<input type='radio' name='action' value='average'>Середнє арифметичне</input>");
        out.println("<input type='radio' name='action' value='min'>Мінімальне число</input>");
        out.println("<input type='submit'></input>");
        out.println("<p>" + nums[0] + " " + nums[1] + " " + nums[2] + "</p>");
        out.println("Результат: " + result);
        out.println("<form></body></html>");
    }

    public void destroy() {
    }
}