package com.travel.photoplanner.service;


import com.travel.photoplanner.entity.Location;
import com.travel.photoplanner.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Location findLocationById(int id){
        return locationRepository.findById(id);
    }

    /**
     *
     * @param name
     * @param description
     * @param coordinates
     * @param priority
     * @param picture
     * @return
     */
    public Location saveLocation(String name, String description, String coordinates, int priority, String picture){
        Location location = locationRepository.save(new Location(name, description, coordinates, priority, picture));
        return location;
    }

}
