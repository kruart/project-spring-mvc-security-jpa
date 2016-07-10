package ua.kruart.traineeship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kruart.traineeship.model.User;
import ua.kruart.traineeship.repository.UserRepository;
import ua.kruart.traineeship.util.ExceptionUtil;
import ua.kruart.traineeship.util.NotFoundException;

import java.util.List;

/**Created by kruart on 10.07.2016.*/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(int id) {
        ExceptionUtil.check(repository.delete(id), id);
    }

    public User get(int id) throws NotFoundException {
        return ExceptionUtil.check(repository.get(id), id);
    }

    public User getByEmail(String email) throws NotFoundException {
        return ExceptionUtil.check(repository.getByEmail(email), "email=" + email);
    }

    public List<User> getAll() {
        return repository.getAll();
    }

    public void update(User user) {
        repository.save(user);
    }
}
