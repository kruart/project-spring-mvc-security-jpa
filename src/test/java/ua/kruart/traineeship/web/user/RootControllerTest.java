package ua.kruart.traineeship.web.user;

import org.junit.Test;
import ua.kruart.traineeship.web.AbstractControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static ua.kruart.traineeship.TestUtil.authorize;
import static ua.kruart.traineeship.UserTestData.ADMIN;
import static ua.kruart.traineeship.UserTestData.USER;

/**Created by Arthur on 22.08.2016.*/

public class RootControllerTest extends AbstractControllerTest {

    @Test
    public void testUserList() throws Exception {
        authorize(ADMIN);
        mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("userList"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/userList.jsp"));
    }

    @Test
    public void testUserListUnAuth() throws Exception {
        authorize(USER);
        mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("exception/exception"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/exception/exception.jsp"));
    }

    public void testMealList() throws Exception {
        authorize(USER);
        mockMvc.perform(get("/meals"))
                .andDo(print())
                .andExpect(view().name("mealList"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/mealList.jsp"));
    }
}