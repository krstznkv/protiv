package com.example.demo.repo;

import com.example.demo.entity.report.TicketDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketDBRepo extends JpaRepository<TicketDB,Long> {

}
