package com.travel.photoplanner.controller;

import com.travel.photoplanner.entity.Day;
import com.travel.photoplanner.entity.Location;
import com.travel.photoplanner.entity.Trip;
import com.travel.photoplanner.helper.PhototripHelper;
import com.travel.photoplanner.repository.DayRepository;
import com.travel.photoplanner.repository.LocationRepository;
import com.travel.photoplanner.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Controller
public class TripController {

    private Set<Day> daySet;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private DayRepository dayRepository;

    @Autowired
    private LocationRepository locationRepository;


    @RequestMapping("/")
    public ModelAndView index(ModelAndView modelAndView){

        modelAndView.addObject("trips", tripRepository.findAll());
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

        Date startDateParsed = PhototripHelper.parseStringToDate(startDate);
        Date endDateParsed = PhototripHelper.parseStringToDate(endDate);

        Trip trip = new Trip(country, startDateParsed, endDateParsed);

        tripRepository.save(trip);

        return "index";
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

        Location location = locationRepository.save(new Location(name, description, coordinates, priority, picture));

        Day day = saveDay(date, location);
        Trip trip = saveTrip(id, day);

        modelAndView.addObject("trip", trip);
        modelAndView.setViewName("detail");

        return modelAndView;

    }

    private Trip saveTrip(int id, Day day) {
        Trip trip = tripRepository.findById(id);

        daySet = trip.getDaySet();
        daySet.add(day);

        trip = tripRepository.save(trip);

        return trip;
    }

    private Day saveDay(String date, Location location) throws ParseException {
        Date locationDateDay = PhototripHelper.parseStringToDate(date);

        Set<Location> locationSet = new HashSet<Location>();

        Day day = dayRepository.findByDate(locationDateDay);
        if(day  == null){
            day = new Day(locationDateDay, locationSet);
        }else{
            locationSet = day.getLocationSet();
        }

        locationSet.add(location);

        day = dayRepository.save(day);

        return day;
    }


    @RequestMapping("/detail")
    public ModelAndView detail(@RequestParam(value = "id") int id,
                               ModelAndView modelAndView){

        modelAndView.addObject("trip", tripRepository.findById(id));
        modelAndView.setViewName("detail");

        return modelAndView;
    }

    @RequestMapping("/day")
    public ModelAndView day(@RequestParam(value = "id") int id,
                            ModelAndView modelAndView){

        modelAndView.addObject("day", dayRepository.findById(id));
        modelAndView.setViewName("day");

        return modelAndView;
    }


    @RequestMapping("/location")
    public ModelAndView location(@RequestParam(value = "id") int id,
                                 ModelAndView modelAndView){

        modelAndView.addObject("location", locationRepository.findById(id));
        modelAndView.setViewName("location");

        return modelAndView;
    }

    @RequestMapping("/editDay")
    public ModelAndView editDay(@RequestParam(value = "id") int id,
                                ModelAndView modelAndView) {
        /*TODO: Work in Progress*/

        Day day = dayRepository.findById(id);

        modelAndView.setViewName("edit/editDay");
        return modelAndView;

    }

}

