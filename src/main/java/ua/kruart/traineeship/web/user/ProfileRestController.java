package ua.kruart.traineeship.web.user;

import org.springframework.stereotype.Controller;
import ua.kruart.traineeship.LoggedUser;
import ua.kruart.traineeship.model.User;

/**Created by kruart on 10.07.2016.*/
@Controller
public class ProfileRestController extends AbstractUserController {

    public User get() {
        return super.get(LoggedUser.id());
    }

    public void delete() {
        super.delete(LoggedUser.id());
    }

    public void update(User user) {
        super.update(user, LoggedUser.id());
    }
}
