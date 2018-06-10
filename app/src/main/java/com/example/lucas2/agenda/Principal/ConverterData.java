package com.example.lucas2.agenda.Principal;

import android.arch.persistence.room.TypeConverter;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lucas on 10/06/2018.
 */

public class ConverterData {

    private static DateFormat df = new SimpleDateFormat("HH:mm");


    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public static Time FromTimeStr(String value) {
        try {
            return value == null ? null : new Time(df.parse(value).getTime()) ;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @TypeConverter
    public static String TimeToString(Time time) {
        return time == null ? null : df.format(time);
    }
}