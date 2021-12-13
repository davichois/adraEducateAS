package com.adra.educate.repository;

import com.adra.educate.entity.PedidosOracionReport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoOracionReportRepository extends CrudRepository<PedidosOracionReport, Integer> {

    @Query(value = "SELECT p FROM PedidosOracionReport p")
    List<PedidosOracionReport> findAllPedidosOracionReport();

}
