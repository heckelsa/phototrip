package com.travel.photoplanner.repository;

import com.travel.photoplanner.entity.Day;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface DayRepository extends CrudRepository<Day, Long> {

    Day findByDate(Date day);

    Day findById(int id);

}