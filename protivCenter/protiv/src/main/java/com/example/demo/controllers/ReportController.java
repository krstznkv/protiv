package com.example.demo.controllers;

import com.example.demo.entity.reports.EpizootologicalExamination;
import com.example.demo.services.ExcelService;
import com.example.demo.services.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;
    private final ExcelService excelService;

    @PostMapping("saveReport")
    public ResponseEntity<EpizootologicalExamination> saveReport(@RequestBody EpizootologicalExamination rep) {
        return ResponseEntity.ok(reportService.saveReport(rep));
    }
    @GetMapping("findReport/{id}/{year}/{month}")
    public ResponseEntity<EpizootologicalExamination> findReport(@PathVariable Long id, @PathVariable int year, @PathVariable int month) {
        return ResponseEntity.ok(reportService.findReportForStation(id,year,month));
    }
    @GetMapping("findAllReport/{year}/{month}")
    public ResponseEntity<Resource> findAllReport(@PathVariable int year, @PathVariable int month) throws IOException {
         Resource file=excelService.getEpExReport(year, month);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }
}
