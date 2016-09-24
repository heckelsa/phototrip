package com.travel.photoplanner.service;


import com.travel.photoplanner.entity.Day;
import com.travel.photoplanner.entity.Trip;
import com.travel.photoplanner.helper.PhototripHelper;
import com.travel.photoplanner.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;
import java.util.Set;

@Component
public class TripService {

    private Set<Day> daySet;

    @Autowired
    private TripRepository tripRepository;

    public Iterable<Trip> findAllTrips(){
        return tripRepository.findAll();
    }

    public Trip findTripById(int id){
        return tripRepository.findById(id);
    }

    /**
     *
     * @param country
     * @param start
     * @param end
     * @return
     * @throws ParseException
     */
    public Trip saveNewTrip(String country, String start, String end) throws ParseException {
        Date startDate = PhototripHelper.parseStringToDate(start);
        Date endDate = PhototripHelper.parseStringToDate(end);

        Trip trip = new Trip(country, startDate, endDate);

        tripRepository.save(trip);

        return trip;
    }

    /**
     *
     * @param id
     * @param day
     * @return
     */
    public Trip addDayToTrip(int id, Day day) {
        Trip trip = tripRepository.findById(id);

        daySet = trip.getDaySet();
        daySet.add(day);

        trip = tripRepository.save(trip);

        return trip;
    }
}
