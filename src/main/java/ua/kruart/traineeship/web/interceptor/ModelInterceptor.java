package ua.kruart.traineeship.web.interceptor;



import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import ua.kruart.traineeship.LoggedUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Arthur on 30.08.2016.*
 * This interceptor adds the user to the model of every requests managed
 */
public class ModelInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null && !modelAndView.isEmpty() && modelAndView.getModelMap().get("user") == null) {
            LoggedUser loggedUser = LoggedUser.safeGet();
            if (loggedUser != null) {
                modelAndView.getModelMap().addAttribute("userTo", loggedUser.getUserTo());
            }
        }
    }
}
