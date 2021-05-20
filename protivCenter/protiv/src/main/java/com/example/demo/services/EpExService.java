package com.example.demo.services;

import com.example.demo.entity.reports.EpizootologicalExamination;
import com.example.demo.repo.EpExRepo;
import com.example.demo.services.base.ReportAbstractService;
import org.springframework.stereotype.Service;

@Service
public class EpExService extends ReportAbstractService<EpizootologicalExamination, EpExRepo> {
    public EpExService(EpExRepo repository) {
        super(repository);
    }
}
