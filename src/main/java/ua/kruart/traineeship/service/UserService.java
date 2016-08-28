package ua.kruart.traineeship.service;

import ua.kruart.traineeship.model.User;
import ua.kruart.traineeship.to.UserTo;
import ua.kruart.traineeship.util.NotFoundException;

import java.util.List;

/**Created by kruart on 10.07.2016.*/

public interface UserService {

    User save(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    void update(UserTo user);

    List<User> getAll();

    void update(User user);

    void evictCache();

    void enable(int id, boolean enable);

    User getWithMeals(int id);
}
