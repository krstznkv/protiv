package com.example.demo.repo;
import com.example.demo.entity.Station;
import com.example.demo.entity.reports.EpizootologicalExamination;
import com.example.demo.entity.reports.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<EpizootologicalExamination,Long> {
  EpizootologicalExamination findByStationAndYearAndMonth(Station station, int year, int month);
}
