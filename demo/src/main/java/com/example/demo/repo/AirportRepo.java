package com.example.demo.repo;

import com.example.demo.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepo extends JpaRepository<Airport,Long> {
   List<Airport> findAll();
   Airport findByCode(String code);
}
