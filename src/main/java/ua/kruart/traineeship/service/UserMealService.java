package ua.kruart.traineeship.service;

import ua.kruart.traineeship.model.UserMeal;
import ua.kruart.traineeship.util.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;

/**Created by kruart on 10.07.2016.*/
public interface UserMealService {
    UserMeal get(int id, int userId) throws NotFoundException;

    void delete(int id, int userId) throws NotFoundException;

    default Collection<UserMeal> getBetweenDates(LocalDate startDate, LocalDate endDate, int userId) {
        return getBetweenDateTimes(LocalDateTime.of(startDate, LocalTime.MIN), LocalDateTime.of(endDate, LocalTime.MAX), userId);
    }

    Collection<UserMeal> getBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId);

    Collection<UserMeal> getAll(int userId);

    UserMeal update(UserMeal meal, int userId) throws NotFoundException;

    UserMeal save(UserMeal meal, int userId);
}
