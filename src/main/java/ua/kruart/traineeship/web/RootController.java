package ua.kruart.traineeship.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.kruart.traineeship.LoggedUser;
import ua.kruart.traineeship.service.UserMealService;
import ua.kruart.traineeship.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**Created by kruart on 20.08.2016.*/

@Controller
public class RootController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMealService mealService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "index";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userList(Model model) {
        model.addAttribute("userList", userService.getAll());
        return "userList";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String setUser(HttpServletRequest request) {
        int userId = Integer.valueOf(request.getParameter("userId"));
        LoggedUser.setId(userId);
        return "redirect:meals";
    }
}
