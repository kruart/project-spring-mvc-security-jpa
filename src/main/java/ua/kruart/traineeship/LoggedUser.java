package ua.kruart.traineeship;

import ua.kruart.traineeship.model.BaseEntity;
import ua.kruart.traineeship.util.UserUtil;

/**Created by kruart on 10.07.2016.*/
public class LoggedUser {
    public static int id = BaseEntity.START_SEQ;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        LoggedUser.id = id;
    }

    public static int getCaloriesPerDay() {
        return UserUtil.DEFAULT_CALORIES_PER_DAY;
    }
}
