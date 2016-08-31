package ua.kruart.traineeship.web.user;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.kruart.traineeship.LoggedUser;
import ua.kruart.traineeship.model.User;
import ua.kruart.traineeship.to.UserTo;
import ua.kruart.traineeship.web.ExceptionInfoHandler;

/**Created by kruart on 10.07.2016.*/

@RestController
@RequestMapping(ProfileRestController.REST_URL)
public class ProfileRestController extends AbstractUserController implements ExceptionInfoHandler {
    public static final String REST_URL = "/rest/profile";

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User get() {
        return super.get(LoggedUser.id());
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete() {
        super.delete(LoggedUser.id());
    }

    public void update(@RequestBody UserTo userTo) {
        userTo.setId(LoggedUser.id());
        super.update(userTo);
    }

    @RequestMapping(value = "/text", method = RequestMethod.GET)
    public String testUTF() {
        return "Русский текст";
    }
}
