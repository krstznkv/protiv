package com.example.demo.services;

import com.example.demo.entity.Station;
import com.example.demo.entity.reports.EpizootologicalExamination;
import com.example.demo.repo.ReportRepository;
import com.example.demo.repo.StationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    @Autowired
    ReportRepository reportRepository;
    @Autowired
    StationRepo stationRepo;
    public EpizootologicalExamination findReportForStation(Long station_id, int year, int month){
        Station station=stationRepo.findById(station_id).get();
        return reportRepository.findByStationAndYearAndMonth(station, year, month);
    }
    public EpizootologicalExamination saveReport(EpizootologicalExamination report){
        return reportRepository.save(report);
    }
}
