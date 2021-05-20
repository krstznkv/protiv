package com.example.demo.controllers.base;

import com.example.demo.entity.reports.ReportBase;
import com.example.demo.services.ExcelService;
import com.example.demo.services.base.ReportCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class ReportAbstractController <E extends ReportBase,S extends ReportCommonService<E>> implements ReportCommonController<E> {
    protected final S reportService;
    protected final ExcelService excelService;
    @Autowired
    protected ReportAbstractController(S service, ExcelService excelService) {
        this.reportService = service;
        this.excelService = excelService;
    }
    @Override
    public ResponseEntity<E> saveReport(@RequestBody E rep) {
        return ResponseEntity.ok(reportService.saveReport(rep));
    }
    @Override
    public ResponseEntity<E> findReport(@PathVariable Long id, @PathVariable int year, @PathVariable int month) {
        return ResponseEntity.ok(reportService.findReportForStation(id,year,month));
    }

}
