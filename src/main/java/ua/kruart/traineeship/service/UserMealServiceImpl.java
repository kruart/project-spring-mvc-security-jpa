package ua.kruart.traineeship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kruart.traineeship.model.UserMeal;
import ua.kruart.traineeship.repository.UserMealRepository;
import ua.kruart.traineeship.util.ExceptionUtil;

import java.time.LocalDateTime;
import java.util.Collection;

/**Created by kruart on 10.07.2016.*/
@Service
public class UserMealServiceImpl implements UserMealService {

    @Autowired
    private UserMealRepository repository;

    @Override
    public UserMeal get(int id, int userId) {
        return ExceptionUtil.check(repository.get(id, userId), id);
    }

    @Override
    public void delete(int id, int userId) {
        ExceptionUtil.check(repository.delete(id, userId), id);
    }

    @Override
    public Collection<UserMeal> getBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId) {
        return repository.getBetween(startDateTime, endDateTime, userId);
    }

    @Override
    public Collection<UserMeal> getAll(int userId) {
        return repository.getAll(userId);
    }

    @Override
    public UserMeal update(UserMeal meal, int userId) {
        return ExceptionUtil.check(repository.save(meal, userId), meal.getId());
    }

    @Override
    public UserMeal save(UserMeal meal, int userId) {
        return repository.save(meal, userId);
    }

//    @Autowired
//    private UserRepository userRepository;

    //    @Transactional
    public UserMeal getWithUser(Integer id, Integer userId) {
//        UserMeal meal = get(id, userId);
//        meal.setUser(userRepository.get(userId));
//        return meal;
        return repository.getWithUser(id, userId);
    }
}
