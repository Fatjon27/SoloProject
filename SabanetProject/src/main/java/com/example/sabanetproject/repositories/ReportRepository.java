package com.example.sabanetproject.repositories;

import com.example.sabanetproject.models.Report;
import com.example.sabanetproject.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ReportRepository extends CrudRepository<Report,Long> {
    public ArrayList<Report> findAll();

    @Query(nativeQuery = true,value = "SELECT * FROM reports where report.completed = true;")
    List<Report> findAllReportsCompleted();

    @Query(nativeQuery = true,value = "SELECT * FROM reports where report.refused = true;")
    List<Report> findAllReportsRejected();

    @Query(nativeQuery = true,value = "SELECT * FROM .reports where report.refused = false and report.technician_id =?1;")
    List<Report> findAllReportAcceptedByTechnicianId(Long id);
}
