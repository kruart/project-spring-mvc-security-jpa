package ua.kruart.traineeship.util;

import org.springframework.util.StringUtils;
import ua.kruart.traineeship.model.Role;
import ua.kruart.traineeship.model.User;
import ua.kruart.traineeship.to.UserTo;

/**Created by Arthur on 28.08.2016.*/

public class UserUtil {
    public static final int DEFAULT_CALORIES_PER_DAY = 2000;

    public static User createFromTo(UserTo newUser) {
        return new User(null, newUser.getName(), newUser.getEmail().toLowerCase(), newUser.getPassword(), Role.ROLE_USER);
    }

    public static UserTo asTo(User user) {
        return new UserTo(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getCaloriesPerDay());
    }

    public static User updateFromTo(User user, UserTo userTo) {
        user.setName(userTo.getName());
        user.setEmail(userTo.getEmail().toLowerCase());
        user.setCaloriesPerDay(userTo.getCaloriesPerDay());
        String password = userTo.getPassword();
        if (!StringUtils.isEmpty(password)) {
            user.setPassword(password);
        }
        return user;
    }
}

