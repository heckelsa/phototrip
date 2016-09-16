package com.travel.photoplanner;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationRowMapper implements RowMapper<Location> {

    @Override
    public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
        Location location = new Location();
        location.setId(rs.getInt("Id"));
        location.setName(rs.getString("Name"));
        location.setDescription(rs.getString("Description"));
        location.setCoordinates(rs.getString("Coordinates"));
        location.setPriority(rs.getInt("Priority"));
        location.setPicture(rs.getString("Picture"));
        return location;
    }
}