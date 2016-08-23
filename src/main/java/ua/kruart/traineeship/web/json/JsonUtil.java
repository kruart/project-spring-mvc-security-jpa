package ua.kruart.traineeship.web.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectReader;
import ua.kruart.traineeship.LoggerWrapper;

import java.io.IOException;
import java.util.List;

import static ua.kruart.traineeship.web.json.JacksonObjectMapper.getMapper;

/**Created by Arthur on 23.08.2016.*/

public class JsonUtil {

    private static final LoggerWrapper LOG = LoggerWrapper.get(JsonUtil.class);

    public static <T> List<T> readValues(String json, Class<T> clazz) {
        ObjectReader reader = getMapper().readerFor(clazz);
        try {
            return reader.<T>readValues(json).readAll();
        } catch (IOException e) {
            throw LOG.getIllegalArgumentException("Invalid read array from JSON:\n'" + json + "'", e);
        }
    }

    public static <T> T readValue(String json, Class<T> clazz) {
        try {
            return getMapper().readValue(json, clazz);
        } catch (IOException e) {
            throw LOG.getIllegalArgumentException("Invalid read from JSON:\n'" + json + "'", e);
        }
    }

    public static <T> String writeValue(T obj) {
        try {
            return getMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Invalid write to JSON:\n'" + obj + "'", e);
        }
    }
}
