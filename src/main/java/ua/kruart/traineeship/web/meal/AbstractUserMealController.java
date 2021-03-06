package ua.kruart.traineeship.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.kruart.traineeship.LoggedUser;
import ua.kruart.traineeship.LoggerWrapper;
import ua.kruart.traineeship.model.UserMeal;
import ua.kruart.traineeship.service.UserMealService;
import ua.kruart.traineeship.to.UserMealWithExceed;
import ua.kruart.traineeship.util.UserMealsUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**Created by kruart on 21.08.2016.*/

@Controller
public class AbstractUserMealController {
    protected static final LoggerWrapper LOG = LoggerWrapper.get(AbstractUserMealController.class);

    @Autowired
    protected UserMealService service;

    public UserMeal get(int id) {
        int userId = LoggedUser.id();
        LOG.info("get meal {} for User {}", id, userId);
        return service.get(id, userId);
    }

    public void delete(int id) {
        int userId = LoggedUser.id();
        LOG.info("delete meal {} for User {}", id, userId);
        service.delete(id, userId);
    }

    public List<UserMealWithExceed> getAll() {
        int userId = LoggedUser.id();
        LOG.info("getAll for User {}", userId);
        return UserMealsUtil.getWithExceeded(service.getAll(userId), LoggedUser.getCaloriesPerDay());
    }

    public void update(UserMeal meal, int id) {
        meal.setId(id);
        int userId = LoggedUser.id();
        LOG.info("update {} for User {}", meal, userId);
        service.update(meal, userId);
    }

    public UserMeal create(UserMeal meal) {
        meal.setId(null);
        int userId = LoggedUser.id();
        LOG.info("create {} for User {}", meal, userId);
        return service.save(meal, userId);
    }

    public List<UserMealWithExceed> getBetween(LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        int userId = LoggedUser.id();
        LOG.info("getBetween dates {} - {} for time {} - {} for User {}", startDate, endDate, startTime, endTime, userId);
        return UserMealsUtil.getFilteredWithExceeded(
                service.getBetweenDates(startDate, endDate, userId), startTime, endTime, LoggedUser.getCaloriesPerDay()
        );
    }
}
