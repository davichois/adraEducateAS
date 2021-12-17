package com.adra.educate.repository;

import com.adra.educate.entity.BCC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BCCRepository extends JpaRepository<BCC, Integer> {

    @Query(value = "CALL SP_INS_TMV_BCC(:idBanco, :idCapacitacion)", nativeQuery = true)
    BCC saveBCC(@Param("idBanco") int idBanco, @Param("idCapacitacion") int idCapacitacion);

}
