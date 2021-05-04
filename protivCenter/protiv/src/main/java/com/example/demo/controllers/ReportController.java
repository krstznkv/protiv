package com.example.demo.controllers;

import com.example.demo.entity.User;
import com.example.demo.entity.reports.EpizootologicalExamination;
import com.example.demo.repo.ReportRepository;
import com.example.demo.services.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;
    @PostMapping("saveReport")
    public ResponseEntity<EpizootologicalExamination> saveReport(@RequestBody EpizootologicalExamination rep) {
        return ResponseEntity.ok(reportService.saveReport(rep));
    }
    @GetMapping("findReport/{id}/{year}/{month}")
    public ResponseEntity<EpizootologicalExamination> findReport(@PathVariable Long id, @PathVariable int year, @PathVariable int month) {
        return ResponseEntity.ok(reportService.findReportForStation(id,year,month));
    }
}
