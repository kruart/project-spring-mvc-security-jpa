package ua.kruart.traineeship.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.kruart.traineeship.UserTestData;
import ua.kruart.traineeship.model.User;
import ua.kruart.traineeship.repository.UserRepository;
import ua.kruart.traineeship.util.NotFoundException;
import ua.kruart.traineeship.web.user.AdminRestController;

import java.util.Collection;

import static ua.kruart.traineeship.UserTestData.ADMIN;
import static ua.kruart.traineeship.UserTestData.USER;

/**Created by kruart on 18.07.2016.*/
@ContextConfiguration({"classpath:spring/spring-app.xml","classpath:spring/spring-mvc.xml", "classpath:spring/mock.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringAdminInMemoryTest {

    @Autowired
    private AdminRestController controller;

    @Autowired
    private UserRepository repository;

    @Before
    public void setUp() throws Exception {
        repository.getAll().forEach(u -> repository.delete(u.getId()));
        repository.save(USER);
        repository.save(ADMIN);
    }

    @Test
    public void testDelete() throws Exception {
        controller.delete(UserTestData.USER_ID);
        Collection<User> users = controller.getAll();
        Assert.assertEquals(users.size(), 1);
        Assert.assertEquals(users.iterator().next(), ADMIN);
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteNotFound() throws Exception {
        controller.delete(10);
    }
}
