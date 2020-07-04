package com.example.demo.services.parser;

import com.example.demo.entity.Airport;
import com.example.demo.entity.City;
import com.example.demo.repo.AirportRepo;
import com.example.demo.repo.CityRepo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
@Service
public class ParserCityService {
    @Autowired
    CityRepo cityRepo;
    private ObjectMapper objectMapper=new ObjectMapper();
    public void parse(String filename) throws IOException {
        String file= new String(Files.readAllBytes(Paths.get(filename)));
        JsonNode jsonNode=objectMapper.readTree(file);
        List<JsonNode> codes=jsonNode.findValues("code");
        List<JsonNode> names=jsonNode.findValues("name");
        for (int i=0;i<codes.size();i++){
            String code=codes.get(i).toString();
            String name=names.get(i).toString();
            City city= new City(code.substring(1,code.length()-1),name.substring(1,name.length()-1));
            cityRepo.save(city);


        }
    }
}
