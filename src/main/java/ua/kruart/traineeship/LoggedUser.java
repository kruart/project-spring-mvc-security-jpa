package ua.kruart.traineeship;

import ua.kruart.traineeship.util.UserMealsUtil;

/**Created by kruart on 10.07.2016.*/
public class LoggedUser {

    public static int id() {
        return 1;
    }

    public static int getCaloriesPerDay() {
        return UserMealsUtil.DEFAULT_CALORIES_PER_DAY;
    }
}
