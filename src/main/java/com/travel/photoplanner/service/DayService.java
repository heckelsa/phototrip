package com.travel.photoplanner.service;

import com.travel.photoplanner.entity.Day;
import com.travel.photoplanner.entity.Location;
import com.travel.photoplanner.helper.DateHelper;
import com.travel.photoplanner.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.*;

@Component
public class DayService {

    @Autowired
    private DayRepository dayRepository;


    public Day findDayById(int id){
        return dayRepository.findById(id);
    }

    public Day saveDay(Day day){
       return dayRepository.save(day);
    }

    public Day findDayByDate(Date date){
        return dayRepository.findByDate(date);
    }


    /**
     *
     * @param day
     * @param location
     * @return
     */
    public Day removeLocationFromDay(Day day, Location location){
        List<Location> locationList = day.getLocationList();
        locationList.remove(location);
        day.setLocationList(locationList);
        day = saveDay(day);
        return day;
    }

    /**
     *
     * @param date
     * @param location
     * @return
     * @throws ParseException
     */
    public Day addLocationToDay(String date, Location location) throws ParseException {
        Date locationDateDay = DateHelper.parseStringToDate(date);

        List<Location> locationList = new LinkedList<>();

        Day day = findDayByDate(locationDateDay);
        if(day  == null){
            day = new Day(locationDateDay, locationList);
        }else{
            locationList = day.getLocationList();
        }

        locationList.add(location);

        day = saveDay(day);

        return day;
    }

}
