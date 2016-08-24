package ua.kruart.traineeship.util.converter;

import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;
import ua.kruart.traineeship.util.TimeUtil;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**Created by Arthur on 24.08.2016.*/

public class LocalTimeFormatter implements Formatter<LocalTime> {

    @Override
    public LocalTime parse(String text, Locale locale) throws ParseException {
        return TimeUtil.parseLocalTime(text, null);
    }

    @Override
    public String print(LocalTime lt, Locale locale) {
        return lt.format(DateTimeFormatter.ISO_LOCAL_TIME);
    }
}
