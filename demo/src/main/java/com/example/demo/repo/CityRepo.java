package com.example.demo.repo;

import com.example.demo.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends CrudRepository<City, Long> {
    City findByName(String name);
}
