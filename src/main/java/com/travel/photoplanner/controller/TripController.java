package com.travel.photoplanner.controller;

import com.travel.photoplanner.service.TripService;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;


@Controller
public class TripController {

    @Autowired
    private TripService tripService;


    @RequestMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {

        modelAndView.addObject("trips", tripService.findAllTrips());
        modelAndView.setViewName("index");

        return modelAndView;
    }


    @RequestMapping("/newTrip")
    public String newTrip() {
        return "new/newTrip";
    }


    @RequestMapping("/createTrip")
    public String newTrip(@RequestParam(value = "country") String country,
                          @RequestParam(value = "startdate") String startDate,
                          @RequestParam(value = "enddate") String endDate) throws ParseException {

        country     = StringEscapeUtils.escapeHtml(country);
        startDate   = StringEscapeUtils.escapeHtml(startDate);
        endDate     = StringEscapeUtils.escapeHtml(endDate);

        tripService.saveNewTrip(country, startDate, endDate);

        return "index";
    }


    @RequestMapping("/detail")
    public ModelAndView detail(@RequestParam(value = "id") int id,
                               ModelAndView modelAndView) {

        modelAndView.addObject("trip", tripService.findTripById(id));
        modelAndView.setViewName("detail");

        return modelAndView;
    }

}

