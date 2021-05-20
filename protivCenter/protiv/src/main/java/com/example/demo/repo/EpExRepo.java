package com.example.demo.repo;

import com.example.demo.entity.reports.EpizootologicalExamination;
import com.example.demo.repo.base.ReportCommonRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface EpExRepo extends ReportCommonRepo<EpizootologicalExamination> {
}

