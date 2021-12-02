package com.adra.educate.repository;

import com.adra.educate.entity.BancosComunal;
import com.adra.educate.entity.Capacitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BancosComunalRepository extends JpaRepository<BancosComunal, Integer> {

    @Query(value = "CALL SP_LIST_BANCOCOMUNAL", nativeQuery = true)
    List<BancosComunal> listBancoComunal();

    @Query(value = "CALL SP_BUSCAR_BANCOCOMUNAL(:idBancoComunal)", nativeQuery = true)
    Optional<BancosComunal> findBancoComunal(@Param("idBancoComunal") int idBancoComunal);

    @Query(value = "CALL SP_INS_BANCOCOMUNAL(:noBancoComunal, :idDistrito)", nativeQuery = true)
    BancosComunal saveBancoComunal(
            @Param("noBancoComunal") String noBancoComunal, @Param("idDistrito") int idDistrito
    );

    @Query(value = "CALL SP_UPD_BANCOCOMUNAL(:idBancoComunal, :noBancoComunal, :idDistrito)", nativeQuery = true)
    BancosComunal updateBancoComunal(
            @Param("idBancoComunal") int idBancoComunal, @Param("noBancoComunal") String noBancoComunal, @Param("idDistrito") int idDistrito
    );

    @Query(value = "CALL SP_DEL_BANCOCOMUNAL(:idBancoComunal)", nativeQuery = true)
    BancosComunal deleteBancoComunal(@Param("idBancoComunal") int idBancoComunal);


}
