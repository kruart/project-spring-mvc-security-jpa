package ua.kruart.traineeship.web;

import ua.kruart.traineeship.LoggerWrapper;
import ua.kruart.traineeship.util.UserMealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**Created by kruart on 09.07.2016.*/
public class MealServlet extends HttpServlet{
    private static final LoggerWrapper LOG = LoggerWrapper.get(MealServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.info("getAll");
        request.setAttribute("mealList",
                UserMealsUtil.getWithExceeded(UserMealsUtil.MEAL_LIST, 2000));
        request.getRequestDispatcher("/mealList.jsp").forward(request, response);
    }
}
