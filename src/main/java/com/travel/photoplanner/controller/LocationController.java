package com.travel.photoplanner.controller;

import com.travel.photoplanner.entity.Day;
import com.travel.photoplanner.entity.Location;
import com.travel.photoplanner.entity.Trip;
import com.travel.photoplanner.service.DayService;
import com.travel.photoplanner.service.LocationService;
import com.travel.photoplanner.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

@Controller
public class LocationController {

    @Autowired
    private DayService dayService;

    @Autowired
    private TripService tripService;

    @Autowired
    private LocationService locationService;


    @RequestMapping("/location")
    public ModelAndView location(@RequestParam(value = "id") int id,
                                 ModelAndView modelAndView) {

        modelAndView.addObject("location", locationService.findLocationById(id));
        modelAndView.setViewName("location");

        return modelAndView;
    }


    @RequestMapping("/createLocation")
    public ModelAndView createLocation(@RequestParam(value = "id") int id,
                                       @RequestParam(value = "name") String name,
                                       @RequestParam(value = "description") String description,
                                       @RequestParam(value = "coordinates") String coordinates,
                                       @RequestParam(value = "priority") int priority,
                                       @RequestParam(value = "picture", required = false) String picture,
                                       @RequestParam(value = "date") String date,
                                       ModelAndView modelAndView) throws ParseException {

        Location location = locationService.saveLocation(name, description, coordinates, priority, picture);
        Day day = dayService.addLocationToDay(date, location);
        Trip trip = tripService.addDayToTrip(id, day);

        modelAndView.addObject("trip", trip);
        modelAndView.setViewName("detail");

        return modelAndView;

    }
}
