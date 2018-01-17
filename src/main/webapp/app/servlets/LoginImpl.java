
package main.webapp.app.servlets;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class LoginImpl extends HttpServlet {

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, NullPointerException {
        //Sprawdza czy jestesmy juz zalogowani


            response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();

            if (testLogin(request.getParameter("email"), request.getParameter("pwd"))) {

                //request.setAttribute("trala", "abc");
                request.setAttribute("abc" ,"trala" );
                out.println(request.getAttribute("abc") + "aaa");

                request.getSession().setAttribute("email", request.getParameter("email"));

                out.println(request.getSession().getAttribute("email") + " a");
                out.println(request.getParameter("email"));
                out.println("<html>");
                out.println("<body>");
                out.println("<h1>Hello Servlet method post</h1>");
                out.println(request.getSession().getAttribute("email"));
                out.println(request.getSession().getAttribute("pwd"));
                out.println(request.getParameter("pwd"));
                out.println("");
                out.println("</body>");
                out.println("</html>");
               // response.sendRedirect("menu.jsp");
           } else {
                request.getSession().setAttribute("Wypełnij poprawnie formularz","message" );
                response.sendRedirect("index.jsp");
           }




        }





    private boolean testLogin (String login, String haslo){
        if (login.equals("123")  && haslo.equals("123")  && !haslo.equals("") && !haslo.equals(""))
            return true;
        else return false;
    }

}
