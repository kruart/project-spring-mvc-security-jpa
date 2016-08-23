package ua.kruart.traineeship.web.user;

import org.junit.Test;
import org.springframework.http.MediaType;
import ua.kruart.traineeship.web.AbstractControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ua.kruart.traineeship.UserTestData.ADMIN_ID;

/**Created by Arthur on 23.08.2016.*/

public class AdminRestControllerTest extends AbstractControllerTest {

    public static final String REST_URL = AdminRestController.REST_URL + '/';

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + ADMIN_ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
