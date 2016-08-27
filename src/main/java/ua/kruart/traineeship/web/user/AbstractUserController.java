package ua.kruart.traineeship.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import ua.kruart.traineeship.LoggerWrapper;
import ua.kruart.traineeship.model.User;
import ua.kruart.traineeship.service.UserService;

import java.util.List;

/**Created by kruart on 10.07.2016.*/

public abstract class AbstractUserController {
    protected final LoggerWrapper LOG = LoggerWrapper.get(getClass());

    @Autowired
    private UserService service;

    public List<User> getAll() {
        LOG.info("getAll");
        return service.getAll();
    }

    public User get(int id) {
        LOG.info("get " + id);
        return service.get(id);
    }

    public User create(User user) {
        user.setId(null);
        LOG.info("create " + user);
        return service.save(user);
    }

    public void delete(int id) {
        LOG.info("delete " + id);
        service.delete(id);
    }

    public void update(User user, int id) {
        user.setId(id);
        LOG.info("update " + user);
        service.update(user);
    }

    public User getByMail(String email) {
        LOG.info("getByEmail " + email);
        return service.getByEmail(email);
    }

    public void enable(int id, boolean enabled) {
        LOG.info((enabled ? "enable " : "disable ") + id);
        service.enable(id, enabled);
    }
}