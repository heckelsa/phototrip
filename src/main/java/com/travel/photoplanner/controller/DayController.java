package com.travel.photoplanner.controller;

import com.travel.photoplanner.entity.Day;
import com.travel.photoplanner.entity.Location;
import com.travel.photoplanner.service.DayService;
import com.travel.photoplanner.service.TripService;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

@Controller
public class DayController {

    @Autowired
    private DayService dayService;

    @Autowired
    private TripService tripService;

    @RequestMapping("/day")
    public ModelAndView day(@RequestParam(value = "trip") int tripId,
                            @RequestParam(value = "id") int id,
                            ModelAndView modelAndView) {

        modelAndView.addObject("trip", tripService.findTripById(tripId));
        modelAndView.addObject("day", dayService.findDayById(id));
        modelAndView.setViewName("day");

        return modelAndView;
    }

    @RequestMapping("/saveDay")
    public ModelAndView changeDateForLocation(@RequestParam(value = "id") int id,
                                              @RequestParam(value = "location") int locationId,
                                              @RequestParam(value = "newDate") String newDate,
                                              ModelAndView modelAndView) throws ParseException {



        Day day = dayService.findDayById(id);
        Location location = day.getLocationById(locationId);
        dayService.removeLocationFromDay(day, location);
        Day newDay = dayService.addLocationToDay(StringEscapeUtils.escapeHtml(newDate), location);

        modelAndView.addObject("day", newDay);
        modelAndView.setViewName("day");

        return modelAndView;
    }

    @RequestMapping("/edit-day")
    public ModelAndView editDay(@RequestParam(value = "id") int id,
                                @RequestParam(value = "location") int locationId,
                                ModelAndView modelAndView) {
        Day day = dayService.findDayById(id);

        Location location = day.getLocationById(locationId);

        if (location != null) {
            modelAndView.addObject("location", location);
        }

        modelAndView.addObject("day", day);
        modelAndView.setViewName("edit/edit-day");

        return modelAndView;
    }
}
