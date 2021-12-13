package com.adra.educate.repository;

import com.adra.educate.entity.PersonaReport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaReportRepository extends CrudRepository<PersonaReport, Integer> {

    @Query(value = "SELECT p FROM PersonaReport p")
    List<PersonaReport> findAllPersonaReport();

}
