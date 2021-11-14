package com.appkode.house.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilFunction {

    public static Date dateFromString(String date){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateObj = sdf.parse(date);
            return dateObj;
        } catch (ParseException e) {
            return null;
        }
    }
}
