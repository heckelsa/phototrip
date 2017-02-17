package com.travel.photoplanner.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public final class DateHelper {

    /**
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date parseStringToDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
        Date newDate = format.parse(date);
        return newDate;
    }


    /**
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getFormattedDate(Date date, String format) throws ParseException {
        String formattedDate = new SimpleDateFormat(format).format(date);
        return formattedDate;
    }


    /**
     * Returns a List of all Days which are between the start and enddate. Includes also the start and enddate.
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<Date> getDaysBetweenDates(Date startDate, Date endDate) {
        List<Date> listOfAllDays = new ArrayList<Date>();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        while (calendar.getTime().before(endDate)) {
            listOfAllDays.add(calendar.getTime());
            calendar.add(Calendar.DATE, 1);
        }

        listOfAllDays.add(endDate);

        return listOfAllDays;
    }


}
