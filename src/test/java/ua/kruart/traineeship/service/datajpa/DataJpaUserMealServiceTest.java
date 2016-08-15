package ua.kruart.traineeship.service.datajpa;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import ua.kruart.traineeship.UserTestData;
import ua.kruart.traineeship.model.UserMeal;
import ua.kruart.traineeship.service.AbstractUserMealServiceTest;

import static ua.kruart.traineeship.MealTestData.*;
import static ua.kruart.traineeship.Profiles.DATAJPA;
import static ua.kruart.traineeship.UserTestData.ADMIN_ID;

/**Created by kruart on 13.08.2016.*/

@ActiveProfiles(DATAJPA)
public class DataJpaUserMealServiceTest extends AbstractUserMealServiceTest {
    @Test
    public void testGetWithUser() throws Exception {
        UserMeal adminMeal = service.getWithUser(ADMIN_MEAL_ID, ADMIN_ID);
        MATCHER.assertEquals(ADMIN_MEAL, adminMeal);
        UserTestData.MATCHER.assertEquals(UserTestData.ADMIN, adminMeal.getUser());
    }
}
