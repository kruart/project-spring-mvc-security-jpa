package ua.kruart.traineeship.service.datajpa;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import ua.kruart.traineeship.MealTestData;
import ua.kruart.traineeship.model.User;
import ua.kruart.traineeship.service.AbstractUserServiceTest;

import static ua.kruart.traineeship.Profiles.DATAJPA;
import static ua.kruart.traineeship.UserTestData.*;

/** Created by kruart on 13.08.2016.*/

@ActiveProfiles(DATAJPA)
public class DataJpaUserServiceTest extends AbstractUserServiceTest {
    @Test
    public void testGetWithUser() throws Exception {
        User user = service.getWithMeals(USER_ID);
        MATCHER.assertEquals(USER, user);
        MealTestData.MATCHER.assertCollectionEquals(MealTestData.USER_MEALS, user.getMeals());
    }
}
