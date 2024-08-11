package org.akaichi.servlets;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import static java.lang.Character.valueOf;

@WebServlet(name = "task4Servlet", value = "/task-4-servlet")
public class Task4Servlet extends HttpServlet {

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body><form action='task-4-servlet' method='post'>");
        out.println("<input name='i'></input>");
        out.println("<p></p>");
        out.println("<input type='submit'></input>");
        out.println("<form></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String text = req.getParameter("i");
        char[] chars = text.toCharArray();
        char[] vowels_eng = {'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u', 'Y', 'y' };
        char[] vowels_ukr = {'А', 'а', 'Е', 'е', 'І', 'і', 'О', 'о', 'И', 'и', 'У', 'у' };
        ArrayList<Character> vowels = new ArrayList<>();
        ArrayList<Character> consonants = new ArrayList<>();
        for(char c : chars)
        {
            consonants.add(c);
        }

        int vowel_counter = 0;
        int consonant_counter = text.length();
        for(char c : chars)
        {
            for (int j = 0; j < 12; j++)
            {
                if (c == vowels_eng[j] || c == vowels_ukr[j])
                {
                    vowels.add(c);
                    consonants.remove(consonants.indexOf(c)); //цікавий рядок, якщо використати підсказку то буде IndexOutOfBounds
                    vowel_counter++;
                    consonant_counter--;
                }
            }
        }
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body><form action='task-4-servlet' method='post'>");
        out.println("<input name='i'></input>");
        out.println("<p></p>");
        out.println("<input type='submit'></input>");
        out.println("<h2>Кількість голосних: " + vowel_counter + "<h2>");
        out.println("<h2>Список голосних: ");
        for(char c : vowels)
        {
            if(vowels.indexOf(c) != vowels.size()-1)
            {
                out.println(c + ", ");
            }
            else
            {
                out.println(c + "<h2>");
            }
        }
        out.println("<h2>Кількість приголосних: " + consonant_counter + "<h2>");
        out.println("<h2>Список приголосних: ");
        for(char c : consonants)
        {
            if(consonants.indexOf(c) != consonants.size()-1)
            {
                out.println(c + ", ");
            }
            else
            {
                out.println(c + "<h2>");
            }
        }
        out.println("<form></body></html>");
    }

    public void destroy() {
    }
}
