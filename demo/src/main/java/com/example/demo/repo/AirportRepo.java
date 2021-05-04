package com.example.demo.repo;

import com.example.demo.entity.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepo extends CrudRepository<Airport,Long> {
   List<Airport> findAll();
   Airport findByCode(String code);
   Airport findByName(String name);
}
