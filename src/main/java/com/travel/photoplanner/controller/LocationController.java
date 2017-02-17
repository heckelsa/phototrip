package com.travel.photoplanner.controller;

import com.travel.photoplanner.entity.Day;
import com.travel.photoplanner.entity.Location;
import com.travel.photoplanner.entity.Trip;
import com.travel.photoplanner.service.DayService;
import com.travel.photoplanner.service.LocationService;
import com.travel.photoplanner.service.TripService;
import org.apache.commons.lang.StringEscapeUtils;
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
    public ModelAndView location(@RequestParam(value = "trip") int tripId,
                                 @RequestParam(value = "id") int id,
                                 ModelAndView modelAndView) {

        modelAndView.addObject("trip", tripService.findTripById(tripId));
        modelAndView.addObject("location", locationService.findLocationById(id));
        modelAndView.setViewName("location");

        return modelAndView;
    }

    @RequestMapping("/edit-location")
    public ModelAndView editLocation(@RequestParam(value = "trip") int tripId,
                                     @RequestParam(value = "id") int id,
                                     ModelAndView modelAndView) {
        modelAndView.addObject("trip", tripService.findTripById(tripId));
        modelAndView.addObject("location", locationService.findLocationById(id));
        modelAndView.setViewName("edit/edit-location");
        return modelAndView;
    }

    @RequestMapping("/update-location-order")
    public String updateLocationOrder(@RequestParam(value = "order") String order){

        /* TODO: WIP */
        locationService.sortLocation(StringEscapeUtils.escapeHtml(order));

        return "detail";
    }


    @RequestMapping("/createLocation")
    public ModelAndView createLocation(@RequestParam(value = "trip") int tripId,
                                       @RequestParam(value = "location", required = false, defaultValue = "0") int locationId,
                                       @RequestParam(value = "name") String name,
                                       @RequestParam(value = "description") String description,
                                       @RequestParam(value = "coordinates") String coordinates,
                                       @RequestParam(value = "priority") int priority,
                                       @RequestParam(value = "picture", required = false) String picture,
                                       @RequestParam(value = "date", required = false) String date,
                                       ModelAndView modelAndView) throws ParseException {

        name        = StringEscapeUtils.escapeHtml(name);
        description = StringEscapeUtils.escapeHtml(description);
        coordinates = StringEscapeUtils.escapeHtml(coordinates);
        picture     = StringEscapeUtils.escapeHtml(picture);
        date        = StringEscapeUtils.escapeHtml(date);

        Trip trip;

        if(locationId > 0){
            // Location already exists. Update with new values.
            locationService.updateLocation(locationId, name, description, coordinates, priority, picture);
            trip = tripService.findTripById(tripId);

        }else{
            // Add new Location
            Location location = locationService.saveNewLocation(name, description, coordinates, priority, picture);
            Day day = dayService.addLocationToDay(date, location);
            trip = tripService.addDayToTrip(tripId, day);
        }

        modelAndView.addObject("trip", trip);
        modelAndView.setViewName("detail");

        return modelAndView;

    }

}
