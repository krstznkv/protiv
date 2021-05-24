package com.example.demo.entity.reports;

import com.example.demo.entity.ReportBase;
import lombok.Data;
import javax.persistence.Entity;

@Entity
@Data
public class NaturalFocusOfPlague extends ReportBase {
    private double area_fiz;
    private double area_oper;
    private double nocit;
    private double blox;
    private int orud_pole;
    private int orud_punkt;
    private int enter;
    private double bac_nosit;
    private double krov_all;
    private double krov_blox;
}
