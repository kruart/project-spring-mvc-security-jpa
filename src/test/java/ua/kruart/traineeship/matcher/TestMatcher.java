package ua.kruart.traineeship.matcher;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import ua.kruart.traineeship.web.json.JsonUtil;

/**Created by Arthur on 23.08.2016.*/

abstract public class TestMatcher<T> extends BaseMatcher<String> {
    protected T expected;

    public TestMatcher(T expected) {
        this.expected = expected;
    }

    @Override
    public boolean matches(Object actual) {
        return compare(expected, (String) actual);
    }

    abstract protected boolean compare(T expected, String actual);

    @Override
    public void describeTo(Description description) {
        description.appendText(JsonUtil.writeValue(expected));
    }
}

