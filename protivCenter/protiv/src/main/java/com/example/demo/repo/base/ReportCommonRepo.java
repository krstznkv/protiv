package com.example.demo.repo.base;

import com.example.demo.entity.Station;
import com.example.demo.entity.reports.EpizootologicalExamination;
import com.example.demo.entity.reports.ReportBase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ReportCommonRepo<E extends ReportBase> extends CrudRepository<E, Long> {
    E findByStationAndYearAndMonth(Station station, int year, int month);
    List<E> findAllByYearAndMonth(int year, int month);
    List<E> findAllByYear(int year);
}
