package com.example.demo.services.base;

import com.example.demo.entity.Station;
import com.example.demo.entity.ReportBase;

import java.util.List;

public interface ReportCommonService <E extends ReportBase>{
    E findReportForStation(Long station_id, int year, int month);
    List<E> findAllReports(int year, int month);
    E saveReport(E report);
    List<E> findAllReportsByYear(int year);
    List<Station> stationsWithoutReport(int year,int month);
}
