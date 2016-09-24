package com.travel.photoplanner.service;


import com.travel.photoplanner.entity.Location;
import com.travel.photoplanner.helper.Constants;
import com.travel.photoplanner.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

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

    /**
     *
     * @param locationId
     * @param name
     * @param description
     * @param coordinates
     * @param priority
     * @param picture
     * @return
     */
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

    /**
     *
     * @param sortOrder
     */
    public void sortLocation(String sortOrder){
        String[] orderList = sortOrder.replaceFirst(Constants.REGEX_ITEM_FIRST, "").split(Constants.REGEX_ITEM);

        List<Location> locationListNew = new LinkedList<>();

        for(int i=0; i < orderList.length; i++){
            int listId = Integer.valueOf(orderList[i]);
            Location location = findLocationById(listId);
            locationListNew.add(location);
        }

       /* TODO: Add some sorting Mechanism so that the user is able to sort the location. */
    }

}
