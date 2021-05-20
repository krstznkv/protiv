package com.example.demo.services;

import com.example.demo.entity.reports.NaturalFocusOfPlague;
import com.example.demo.repo.NaturalFocusOfPlagueRepo;
import com.example.demo.services.base.ReportAbstractService;
import org.springframework.stereotype.Service;


@Service
public class NaturalFocusOfPlagueService extends ReportAbstractService<NaturalFocusOfPlague, NaturalFocusOfPlagueRepo> {
    public NaturalFocusOfPlagueService(NaturalFocusOfPlagueRepo repository) {
        super(repository);
    }

}
