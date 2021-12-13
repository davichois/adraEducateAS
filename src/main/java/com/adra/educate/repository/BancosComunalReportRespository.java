package com.adra.educate.repository;

import com.adra.educate.entity.BancosComunalReport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BancosComunalReportRespository extends CrudRepository<BancosComunalReport, Integer> {

    @Query(value = "SELECT b FROM BancosComunalReport b")
    List<BancosComunalReport> findAllBancosComunalReport();

}
