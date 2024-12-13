package com.example.surfeillance_v2_frontend.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public static String getDayOfWeek(String dateString){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = null;
        try {
            date = sdf.parse(dateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            SimpleDateFormat dayOfWeekFormat = new SimpleDateFormat("EEEE", Locale.getDefault());
            return dayOfWeekFormat.format(calendar.getTime());
        } catch (ParseException e) {
            //TODO replace with better logging
            e.printStackTrace();
            throw new RuntimeException("Unparseable date: " + dateString, e);
        }


    }
}
