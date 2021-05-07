package com.example.demo.services;

import com.example.demo.entity.Station;
import com.example.demo.entity.reports.EpizootologicalExamination;
import com.example.demo.repo.ReportRepository;
import com.example.demo.repo.StationRepo;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    public List<EpizootologicalExamination> findAllReports(int year, int month) throws IOException {
        List<EpizootologicalExamination> list= reportRepository.findAllByYearAndMonth(year, month);
        Collections.sort(list, Comparator.comparing(o -> o.getStation().getStationName()));

        return list;
    }
    public EpizootologicalExamination saveReport(EpizootologicalExamination report){
        return reportRepository.save(report);
    }
}
