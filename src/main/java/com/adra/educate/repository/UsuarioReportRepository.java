package com.adra.educate.repository;

import com.adra.educate.entity.UsuarioReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioReportRepository extends CrudRepository<UsuarioReport, Integer> {

    @Query(value = "SELECT u FROM UsuarioReport u")
    List<UsuarioReport> findAllSocioReport();

}
