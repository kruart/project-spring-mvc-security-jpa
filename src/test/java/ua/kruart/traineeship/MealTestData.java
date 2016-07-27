package ua.kruart.traineeship;

import ua.kruart.traineeship.matcher.ModelMatcher;
import ua.kruart.traineeship.model.UserMeal;

/**Created by kruart on 27.07.2016.*/
public class MealTestData {

    public static final ModelMatcher<UserMeal, String> MATCHER = new ModelMatcher<>(UserMeal::toString);

}
