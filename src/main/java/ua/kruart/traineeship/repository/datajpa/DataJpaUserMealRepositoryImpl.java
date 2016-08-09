package ua.kruart.traineeship.repository.datajpa;

import org.springframework.stereotype.Repository;
import ua.kruart.traineeship.model.UserMeal;
import ua.kruart.traineeship.repository.UserMealRepository;

import java.time.LocalDateTime;
import java.util.List;

/**Created by kruart on 09.08.2016.*/
@Repository
public class DataJpaUserMealRepositoryImpl implements UserMealRepository {
    @Override
    public UserMeal save(UserMeal userMeal, int userId) {
        return null;
    }

    @Override
    public boolean delete(int id, int userId) {
        return false;
    }

    @Override
    public UserMeal get(int id, int userId) {
        return null;
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        return null;
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return null;
    }
}
