package ua.kruart.traineeship.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**Created by kruart on 08.07.2016.*/
public class UserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      request.getRequestDispatcher("/userList.jsp").forward(request, response);
        response.sendRedirect("userList.jsp");
    }
}
