package main.webapp.app.servlets;

import main.webapp.app.repository.DBConnection;
import main.webapp.app.repository.DBConnectionImpl;
import main.webapp.app.repository.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

public class RegisterImpl extends HttpServlet {


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();

        // if (request.getParameter("emailreg") == null || request.getParameter("emailreg").equals(""))
        //  response.sendRedirect("index.jsp");
        //  if (request.getParameter("pwdreg") == null || request.getParameter("pwdreg").equals(""))

        // response.sendRedirect("index.jsp");
        //if (request.getParameter("name") == null || request.getParameter("name").equals(""))
        // response.sendRedirect("index.jsp");


        User user = new User(request.getParameter("name"),
                  request.getParameter("emailreg"),
                  request.getParameter("pwdreg"),
                  request.getParameter("country"));
        out.println(user);
        DBConnection dbConnection = null;
        try {
            dbConnection = new DBConnectionImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        long b = 8;
        b = dbConnection.registerUser(user);
        out.println(b);
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Hello Servlet method post</h1>");


        out.println(request.getParameter("pwdreg"));
        out.println(request.getParameter("emailreg"));
        out.println(request.getParameter("name"));
        out.println(request.getParameter("country"));


        out.println("blalblblaslalaldasda : ");
        out.println("");
        out.println("</body>");
        out.println("</html>");
    }
}



