package com.example.demo.controllers.base;

import com.example.demo.entity.Station;
import com.example.demo.entity.ReportBase;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;

public interface ReportCommonController <E extends ReportBase>{
    @PostMapping("saveReport")
    ResponseEntity<E> saveReport(@RequestBody E rep);
    @GetMapping("findReport/{id}/{year}/{month}")
    ResponseEntity<E> findReport(@PathVariable Long id, @PathVariable int year, @PathVariable int month);
    @GetMapping("findAllReport/{year}/{month}")
    ResponseEntity<Resource> findAllReport(@PathVariable int year, @PathVariable int month) throws IOException;
    @GetMapping("findStationWithoutReport/{year}/{month}")
    ResponseEntity<List<Station>> findStationWithoutReport(@PathVariable int year, @PathVariable int month);
}
