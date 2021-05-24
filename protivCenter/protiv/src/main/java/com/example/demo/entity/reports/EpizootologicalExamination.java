package com.example.demo.entity.reports;

import com.example.demo.entity.ReportBase;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class EpizootologicalExamination extends ReportBase {
    private float area_pole;
    private float area_punkt;
    private float orud_pole;
    private float orud_punkt;
    private float mites_km;
    private float mites_h;
    private int mammals_rodents;
    private int mammals_insectivores;
    private int mammals_predators;
    private int mammals_others;
    private int birds;
    private int arthropods_blox;
    private int arthropods_mites;
    private int arthropods_komar;
    private int arthropods_other;
    private int pogadki;
    private float water;
    private float other;
}
