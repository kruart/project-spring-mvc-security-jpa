package ua.kruart.traineeship;

import ua.kruart.traineeship.util.UserMealsUtil;

/**Created by kruart on 10.07.2016.*/
public class LoggedUser {
    public static int id = 1;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        LoggedUser.id = id;
    }

    public static int getCaloriesPerDay() {
        return UserMealsUtil.DEFAULT_CALORIES_PER_DAY;
    }
}
