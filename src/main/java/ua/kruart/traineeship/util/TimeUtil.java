package ua.kruart.traineeship.util;

import java.time.LocalTime;

/**Created by kruart on 05.07.2016.*/
public class TimeUtil {
    public static boolean isBetween(LocalTime lt, LocalTime startTime, LocalTime endTime){
        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTime) <= 0;
    }
}
