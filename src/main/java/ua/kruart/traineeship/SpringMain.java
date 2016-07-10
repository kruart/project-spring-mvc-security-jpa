package ua.kruart.traineeship;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.kruart.traineeship.model.Role;
import ua.kruart.traineeship.model.User;
import ua.kruart.traineeship.service.UserService;

import java.util.Arrays;

/**Created by kruart on 10.07.2016.*/
public class SpringMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println(Arrays.toString(appCtx.getBeanDefinitionNames()));
        UserService userService = appCtx.getBean(UserService.class);
        System.out.println(userService.save(new User(1, "userName", "email", "password", Role.ROLE_ADMIN)));
        appCtx.close();
    }
}
