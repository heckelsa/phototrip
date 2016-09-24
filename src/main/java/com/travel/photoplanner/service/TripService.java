package com.travel.photoplanner.service;


import com.travel.photoplanner.entity.Day;
import com.travel.photoplanner.entity.Trip;
import com.travel.photoplanner.helper.DateHelper;
import com.travel.photoplanner.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.*;

@Component
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private DayService dayService;

    public Iterable<Trip> findAllTrips() {
        return tripRepository.findAll();
    }

    public Trip findTripById(int id) {
        return tripRepository.findById(id);
    }

    /**
     * @param country
     * @param start
     * @param end
     * @return
     * @throws ParseException
     */
    public Trip saveNewTrip(String country, String start, String end) throws ParseException {

        Date startDate = DateHelper.parseStringToDate(start);
        Date endDate = DateHelper.parseStringToDate(end);

        List<Day> dayList = addAllDaysToTrip(startDate, endDate);
        Trip trip = new Trip(country, startDate, endDate, dayList);
        tripRepository.save(trip);

        return trip;
    }


    /**
     * @param id
     * @param day
     * @return
     */
    public Trip addDayToTrip(int id, Day day) {

        Trip trip = tripRepository.findById(id);

        List<Day> dayList = null;
        dayList = trip.getDayList();
        dayList.add(day);

        trip = tripRepository.save(trip);

        return trip;
    }

    /**
     * @param startDate
     * @param endDate
     * @return
     */
    private List<Day> addAllDaysToTrip(Date startDate, Date endDate) {
        List<Day> listOfDays = new LinkedList<>();
        List<Date> listOfAllDays = null;
        listOfAllDays = DateHelper.getDaysBetweenDates(startDate, endDate);

        Iterator<Date> dateListIterator = listOfAllDays.iterator();
        while (dateListIterator.hasNext()) {
            Day day = new Day(dateListIterator.next());
            day = dayService.saveDay(day);
            listOfDays.add(day);
        }

        return listOfDays;
    }


}
