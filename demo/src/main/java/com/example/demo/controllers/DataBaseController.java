package com.example.demo.controllers;

import com.example.demo.entity.Message;
import com.example.demo.entity.report.AirlineTop;
import com.example.demo.services.parser.ParseAirportService;
import com.example.demo.services.parser.ParserCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class DataBaseController {
    @Autowired
     ParserCityService parserCityService;
    @Autowired
     ParseAirportService parseAirportService;

    public DataBaseController() {
    }

    @PostMapping("addCities")
    public ResponseEntity<Message> addCities() throws IOException {
        parserCityService.parse("D:/xml/city.json");
        return ResponseEntity.ok(new Message("OK"));
    }
    @PostMapping("addAirports")
    public ResponseEntity<Message> addPorts() throws IOException {
        parseAirportService.parse("D:/xml/airport.json");
        return ResponseEntity.ok(new Message("OK"));
    }
}
