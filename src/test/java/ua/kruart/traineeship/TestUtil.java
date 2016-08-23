package ua.kruart.traineeship;

import org.springframework.test.web.servlet.ResultActions;
import ua.kruart.traineeship.matcher.ModelMatcher;

import java.io.UnsupportedEncodingException;

/**Created by Arthur on 23.08.2016.*/

public class TestUtil {

    public static ResultActions print(ResultActions action) throws UnsupportedEncodingException {
        System.out.println(getContent(action));
        return action;
    }

    public static String getContent(ResultActions action) throws UnsupportedEncodingException {
        return action.andReturn().getResponse().getContentAsString();
    }

    /**
     * Compare entities using toString
     */
    public static class ToStringModelMatcher<T> extends ModelMatcher<T, String> {
        public ToStringModelMatcher(Class<T> entityClass) {
            super(Object::toString, entityClass);
        }
    }
}
