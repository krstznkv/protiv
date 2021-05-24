package com.example.demo.services.base;

import com.example.demo.entity.Station;
import com.example.demo.entity.ReportBase;
import com.example.demo.repo.base.ReportCommonRepo;
import com.example.demo.repo.StationRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class ReportAbstractService<E extends ReportBase, R extends ReportCommonRepo<E>>
        implements ReportCommonService<E> {
    @Autowired
    StationRepo stationRepo;
    protected final R reportRepository;
    @Autowired
    public ReportAbstractService(R repository) {
        this.reportRepository = repository;
    }
   @Override
    public E findReportForStation(Long station_id, int year, int month){
        Station station=stationRepo.findById(station_id).get();
        return reportRepository.findByStationAndYearAndMonth(station, year, month);
    }
    @Override
    public List<E> findAllReports(int year, int month)  {
        List<E> list= reportRepository.findAllByYearAndMonthAndApproveByDirector(year, month,true);
        Collections.sort(list, Comparator.comparing(o -> o.getStation().getStationName()));

        return list;
    }
    @Override
    public E saveReport(E report){
        return reportRepository.save(report);
    }
    @Override
    public List<E> findAllReportsByYear(int year)  {
        List<E> list= reportRepository.findAllByYear(year);
        Collections.sort(list, Comparator.comparing(o -> o.getStation().getStationName()));

        return list;
    }
    @Override
    public List<Station> stationsWithoutReport(int year,int month) {
        List<Station> allStations = stationRepo.findAll();
        List<E> reports=reportRepository.findAllByYearAndMonthAndApproveByDirector(year, month, true);
        for (E report:reports
             ) {
            allStations.remove(report.getStation());
        }
        return allStations;
    }
}
