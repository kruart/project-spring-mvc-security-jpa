package ua.kruart.traineeship.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.kruart.traineeship.model.UserMeal;
import ua.kruart.traineeship.repository.UserMealRepository;

import java.time.LocalDateTime;
import java.util.List;

/**Created by kruart on 09.08.2016.*/
@Repository
public class DataJpaUserMealRepositoryImpl implements UserMealRepository {
    @Autowired
    private ProxyUserMealRepository proxy;

    @Autowired
    private ProxyUserRepository userProxy;

    @Override
    @Transactional
    public UserMeal save(UserMeal userMeal, int userId) {
        if (!userMeal.isNew() && get(userMeal.getId(), userId) == null) {
            return null;
        }
        userMeal.setUser(userProxy.getOne(userId));
        return proxy.save(userMeal);
    }

    @Override
    public boolean delete(int id, int userId) {
        return proxy.delete(id, userId) != 0;
    }

    @Override
    public UserMeal get(int id, int userId) {
        return proxy.get(id, userId);
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        return proxy.getAll(userId);
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return proxy.getBetween(startDate, endDate, userId);
    }
}
