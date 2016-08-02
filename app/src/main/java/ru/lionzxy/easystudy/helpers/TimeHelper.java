package ru.lionzxy.easystudy.helpers;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by LionZXY on 01.08.2016.
 */
public class TimeHelper {

    public static String timeToString(Time time){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ROOT);
        return sdf.format(time);
    }
}
