package ua.kruart.traineeship.web.user;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.kruart.traineeship.model.User;
import ua.kruart.traineeship.to.UserTo;
import ua.kruart.traineeship.util.UserUtil;

import java.util.List;

/**Created by Arthur on 25.08.2016.*/

@RestController
@RequestMapping("/ajax/admin/users")
public class AdminAjaxController extends AbstractUserController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return super.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createOrUpdate(UserTo userTo) {
        if (userTo.getId() == 0) {
            super.create(UserUtil.createFromTo(userTo));
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void enabled(@PathVariable("id") int id, @RequestParam("enabled") boolean enabled) {
        super.enable(id, enabled);
    }
}

