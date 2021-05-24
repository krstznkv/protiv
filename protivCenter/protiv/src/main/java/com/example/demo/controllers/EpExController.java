package com.example.demo.controllers;

import com.example.demo.controllers.base.ReportAbstractController;
import com.example.demo.entity.Station;
import com.example.demo.entity.reports.EpizootologicalExamination;
import com.example.demo.services.EpExService;
import com.example.demo.services.ExcelService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ExEp")
public class EpExController extends ReportAbstractController<EpizootologicalExamination, EpExService> {

    protected EpExController(EpExService service, ExcelService excelService) {
        super(service, excelService);
    }

    @Override
    public ResponseEntity<Resource> findAllReport(int year, int month) throws IOException {
        List<Station> stNone=reportService.stationsWithoutReport(year, month);
        if(stNone!=null&&stNone.size()!=0)
            throw new IllegalArgumentException("Отсутсвуют данные по станциям");
        List<EpizootologicalExamination> list = reportService.findAllReports(year, month);
        Resource file = excelService.getEpExReport(list);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
                        + file.getFilename() + "\"")
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }
    @GetMapping("/all")
    public List<EpizootologicalExamination> fAll(int year, int month){
        return reportService.findAllReports(year,month);
    }
}
