package com.example.demo.repo;

import com.example.demo.entity.Ticket;
import com.example.demo.entity.report.AirlineTop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AirlineTopRepo extends JpaRepository<AirlineTop,Long> {
   /* @Query("SELECT airline , COUNT(id) as countOfTicket FROM ticket GROUP BY airline")
    List<AirlineTop> findTop();*/
}
