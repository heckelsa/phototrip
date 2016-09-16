package com.travel.photoplanner.controller;

import com.travel.photoplanner.entity.Day;
import com.travel.photoplanner.entity.Location;
import com.travel.photoplanner.entity.Trip;
import com.travel.photoplanner.repository.DayRepository;
import com.travel.photoplanner.repository.LocationRepository;
import com.travel.photoplanner.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Set;

@RestController
public class TripController {

    Set<Location> locationSet;
    Set<Day> daySet;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private DayRepository dayRepository;

    @Autowired
    private LocationRepository locationRepository;

    @RequestMapping("/")
    public Iterable<Trip> showAllTrips(){

        Iterable<Trip> trips = tripRepository.findAll();
        return trips;
    }


    @RequestMapping("/create")
    public
    @ResponseBody
    String createTrip(@RequestParam(value = "name") String name,
                      @RequestParam(value = "description") String description,
                      @RequestParam(value = "coordinates") String coordinates,
                      @RequestParam(value = "priority") int priority,
                      @RequestParam(value = "picture") String picture,
                      @RequestParam(value = "date") Date date,
                      @RequestParam(value = "country") String country,
                      @RequestParam(value = "startDate") Date startDate,
                      @RequestParam(value = "endDate") Date endDate){

        Location location = new Location(name, description, coordinates, priority, picture);

        locationSet.add(location);

        Day day = new Day(date, locationSet);

        daySet.add(day);

        Trip trip = new Trip(country, startDate, endDate, daySet);

        trip = tripRepository.save(trip);

        return trip.toString();
    }

    @RequestMapping("/detail")
    public String showDetail(@RequestParam(value = "id") int id){

        return "Detail";
    }

}

