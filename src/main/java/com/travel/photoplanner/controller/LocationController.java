package com.travel.photoplanner.controller;

import com.travel.photoplanner.entity.Location;
import com.travel.photoplanner.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;


    @RequestMapping("/createLocation")
    public
    @ResponseBody
    String index (@RequestParam(value = "name") String name,
                  @RequestParam(value = "description") String description,
                  @RequestParam(value = "coordinates") String coordinates,
                  @RequestParam(value = "priority") int priority,
                  @RequestParam(value = "picture") String picture){

        Location location = new Location(name, description, coordinates, priority, picture);

        location = locationRepository.save(location);

        return location.toString();
    }

}

