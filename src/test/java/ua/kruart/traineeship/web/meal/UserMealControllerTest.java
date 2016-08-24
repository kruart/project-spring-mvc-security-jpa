package ua.kruart.traineeship.web.meal;

import org.junit.Test;
import ua.kruart.traineeship.web.AbstractControllerTest;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static ua.kruart.traineeship.MealTestData.MEAL1_ID;
import static ua.kruart.traineeship.MealTestData.MEAL1;

/**Created by Arthur on 24.08.2016.*/

public class UserMealControllerTest extends AbstractControllerTest {

    @Test
    public void testMealList() throws Exception {
        mockMvc.perform(get("/meals"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("mealList"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/mealList.jsp"))
                .andExpect(model().attribute("mealList", hasSize(6)))
                .andExpect(model().attribute("mealList", hasItem(
                        allOf(
                                hasProperty("id", is(MEAL1_ID)),
                                hasProperty("description", is(MEAL1.getDescription()))
                        )
                )));
    }
}
