package ua.kruart.traineeship;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.kruart.traineeship.repository.UserRepository;

import java.util.Arrays;

/**Created by kruart on 10.07.2016.*/
public class SpringMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println(Arrays.toString(appCtx.getBeanDefinitionNames()));
        UserRepository userRepository = (UserRepository) appCtx.getBean("mockUserRepository");
        userRepository = appCtx.getBean(UserRepository.class);
        appCtx.close();
    }
}
