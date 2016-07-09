package ua.kruart.traineeship.repository;

import ua.kruart.traineeship.model.UserMeal;

import java.util.Collection;

/**Created by kruart on 09.07.2016.*/
public interface UserMealRepository {
    UserMeal save(UserMeal userMeal);

    void delete(int id);

    UserMeal get(int id);

    Collection<UserMeal> getAll();
}
