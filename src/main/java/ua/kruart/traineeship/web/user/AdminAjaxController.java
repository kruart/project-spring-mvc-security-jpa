package ua.kruart.traineeship.web.user;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.kruart.traineeship.model.User;
import ua.kruart.traineeship.to.UserTo;
import ua.kruart.traineeship.util.UserUtil;
import ua.kruart.traineeship.util.exception.ValidationException;

import javax.validation.Valid;
import java.util.List;

/**Created by Arthur on 25.08.2016.*/

@RestController
@RequestMapping("/ajax/admin/users")
public class AdminAjaxController extends AbstractUserController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return super.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createOrUpdate(@Valid UserTo userTo, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            throw new ValidationException(result);
        }
        status.setComplete();
        try {
            if (userTo.getId() == 0) {
                super.create(UserUtil.createFromTo(userTo));
            } else {
                super.update(userTo);
            }
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("user with this email already present in application");
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void enabled(@PathVariable("id") int id, @RequestParam("enabled") boolean enabled) {
        super.enable(id, enabled);
    }
}

