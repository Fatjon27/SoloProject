package com.example.sabanetproject.services;

import com.example.sabanetproject.models.Report;
import com.example.sabanetproject.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public ArrayList<Report> findAll(){
        return reportRepository.findAll();
    }

    public Report createReport(Report report){
        return reportRepository.save(report) ;
    }

    public Report updateReport(Report report){
        return reportRepository.save(report) ;
    }

    public Report findById(Long id){
        return reportRepository.findById(id).orElse(null);
    }

    public Integer allCompletedReports(){
        Integer completedReports = 0;
        for(Report report: reportRepository.findAllReportsCompleted()){
            completedReports++;
        }
        return completedReports;
    }

    public Integer allRejectedReports(){
        Integer rejectedReports = 0;
        for(Report report : reportRepository.findAllReportsRejected()){
            rejectedReports++;
        }
        return rejectedReports;
    }

    public Integer allProcessedReportsByTechnician(Long id){
        Integer processedReports = 0;
        for(Report report: reportRepository.findAllReportAcceptedByTechnicianId(id)){
            processedReports++;
        }
        return processedReports;
    }
}
