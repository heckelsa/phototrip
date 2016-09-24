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

    public Location saveLocation(Location location){
        return locationRepository.save(location);
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
    public Location saveNewLocation(String name, String description, String coordinates, int priority, String picture){
        Location location = locationRepository.save(new Location(name, description, coordinates, priority, picture));
        return location;
    }

    public Location updateLocation(int locationId, String name, String description, String coordinates,
                                   int priority, String picture){
        Location location = findLocationById(locationId);
        location.setName(name);
        location.setDescription(description);
        location.setCoordinates(coordinates);
        location.setPriority(priority);
        location.setPicture(picture);

        location = saveLocation(location);
        return location;
    }

}
