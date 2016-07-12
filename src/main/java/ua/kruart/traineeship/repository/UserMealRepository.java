package ua.kruart.traineeship.repository;

import ua.kruart.traineeship.model.UserMeal;

import java.time.LocalDateTime;
import java.util.Collection;

/**Created by kruart on 09.07.2016.*/
public interface UserMealRepository {
    // null if updated meal do not belong to userId
    UserMeal save(UserMeal userMeal, int userId);

    // false if meal do not belong to userId
    boolean delete(int id, int userId);

    // null if meal do not belong to userId
    UserMeal get(int id, int userId);

    // ORDERED DATE, TIME
    Collection<UserMeal> getAll(int userId);

    // ORDERED DATE, TIME
    Collection<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId);
}
