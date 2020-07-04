package com.example.demo.repo;

import com.example.demo.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepo extends CrudRepository<City, Long> {
    List<City> findAllByName(String name);
    City findByCode(String code);
}
