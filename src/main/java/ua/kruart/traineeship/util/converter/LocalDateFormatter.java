package ua.kruart.traineeship.util.converter;

import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;
import ua.kruart.traineeship.util.TimeUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**Created by Arthur on 24.08.2016.*/

public class LocalDateFormatter implements Formatter<LocalDate> {

    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        return TimeUtil.parseLocalDate(text, null);
    }

    @Override
    public String print(LocalDate lt, Locale locale) {
        return lt.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
