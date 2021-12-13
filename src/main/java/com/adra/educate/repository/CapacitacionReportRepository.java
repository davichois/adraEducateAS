package com.adra.educate.repository;

import com.adra.educate.entity.CapacitacionReport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CapacitacionReportRepository extends CrudRepository<CapacitacionReport, Integer> {

    @Query(value = "SELECT c FROM CapacitacionReport c")
    List<CapacitacionReport> findAllCapacitacionReport();

}
