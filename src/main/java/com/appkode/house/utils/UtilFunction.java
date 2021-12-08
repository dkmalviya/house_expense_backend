package com.appkode.house.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class UtilFunction {

    public static Date dateFromString(String date) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateObj = sdf.parse(date);
            return dateObj;
        } catch (ParseException e) {
            return null;
        }
    }


    public static Date dateFromString1(String date) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date dateObj = sdf.parse(date);
            return dateObj;
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date startDateOfMonth(String date) {

        DateTimeFormatter df = new DateTimeFormatterBuilder()
                // case insensitive to parse JAN and FEB
                .appendPattern("dd-MM-yyyy")
                // create formatter (use English Locale to parse month names)
                .toFormatter(Locale.ENGLISH);

        LocalDate tempDate = LocalDate.parse(date,df);
        Date startDate = Date.from(tempDate.withDayOfMonth(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return startDate;
    }

    public static Date endDateOfMonth(String date) {
        DateTimeFormatter df = new DateTimeFormatterBuilder()
                // case insensitive to parse JAN and FEB
                // add pattern
                .appendPattern("dd-MM-yyyy")
                // create formatter (use English Locale to parse month names)
                .toFormatter(Locale.ENGLISH);

        LocalDate tempDate = LocalDate.parse(date,df);
        Date endDate = Date.from(tempDate.withDayOfMonth(tempDate.lengthOfMonth()).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return endDate;

    }



}
