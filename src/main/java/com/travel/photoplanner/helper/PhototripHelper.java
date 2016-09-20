package com.travel.photoplanner.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class PhototripHelper {

    public static Date parseStringToDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
        Date newDate = format.parse(date);
        return newDate;
    }


    public static String getFormattedDate(Date date) throws ParseException {
        String formattedDate = new SimpleDateFormat(Constants.DATE_FORMAT).format(date);
        return formattedDate;
    }


}
