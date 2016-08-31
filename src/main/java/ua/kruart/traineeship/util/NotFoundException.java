package ua.kruart.traineeship.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**Created by kruart on 10.07.2016.*/

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No data found")  // 404
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
