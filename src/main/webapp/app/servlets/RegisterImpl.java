package app.servlets;

import app.repository.DBConnection;
import app.repository.DBConnectionImpl;
import app.repository.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterImpl extends HttpServlet {


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html; charset=utf-8");

        PrintWriter out = response.getWriter();


        User user = new User(request.getParameter("name"),
                request.getParameter("emailreg"),
                request.getParameter("pwdreg"),
                request.getParameter("country"));
        out.println(user);
        long b = 0;
        DBConnection dbConnection = null;
        try {
            dbConnection = new DBConnectionImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {

            if (regVerify(user, dbConnection) == true)
                b = dbConnection.registerUser(user);
            else {
                request.getSession().setAttribute("error register", "Email or Name exists in data");
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

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

    public boolean regVerify(User user, DBConnection dbConnection) throws SQLException {
        return dbConnection.checkRegistration(user) != true;
    }
}



