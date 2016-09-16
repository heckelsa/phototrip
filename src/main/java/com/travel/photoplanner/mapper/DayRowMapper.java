package com.travel.photoplanner.mapper;

import com.travel.photoplanner.entity.Day;
import com.travel.photoplanner.entity.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DayRowMapper implements RowMapper<Day> {

    @Override
    public Day mapRow(ResultSet rs, int rowNum) throws SQLException {
        Day day = new Day();
        day.setId(rs.getInt("Id"));
        day.setDate(rs.getDate("Date"));
        return day;
    }
}
