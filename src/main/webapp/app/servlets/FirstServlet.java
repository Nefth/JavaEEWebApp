package app.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/plain; charset=utf-8");

        PrintWriter pw = res.getWriter();

        String st = res.getContentType();

        pw.println("index.jsp " + st);

        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {

    }
}
