package ua.kruart.traineeship.util;

import ua.kruart.traineeship.model.Role;
import ua.kruart.traineeship.model.User;
import ua.kruart.traineeship.to.UserTo;

/**Created by Arthur on 28.08.2016.*/

public class UserUtil {
    public static final int DEFAULT_CALORIES_PER_DAY = 2000;

    public static User createFromTo(UserTo newUser) {
        return new User(null, newUser.getName(), newUser.getEmail().toLowerCase(), newUser.getPassword(), Role.ROLE_USER);
    }
}
