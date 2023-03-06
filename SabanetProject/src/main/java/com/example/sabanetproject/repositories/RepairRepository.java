package com.example.sabanetproject.repositories;

import com.example.sabanetproject.models.Repair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface RepairRepository extends CrudRepository<Repair,Long> {
    public ArrayList<Repair> findAll();

}
