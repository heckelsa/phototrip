package com.travel.photoplanner.mapper;

import com.travel.photoplanner.entity.Trip;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TripRowMapper implements RowMapper<Trip>{

    @Override
    public Trip mapRow(ResultSet rs, int rowNum) throws SQLException {
        Trip trip = new Trip();
        trip.setId(rs.getInt("Id"));
        trip.setCountry(rs.getString("Country"));
        trip.setStartDate(rs.getDate("StartDate"));
        trip.setEndDate(rs.getDate("EndDate"));
        return trip;
    }
}
