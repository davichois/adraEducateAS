package com.adra.educate.repository;

import com.adra.educate.entity.Capacitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CapacitacionRepository extends JpaRepository<Capacitacion, Integer> {

    @Query(value = "CALL SP_LIST_CAPACITACION", nativeQuery = true)
    List<Capacitacion> listCapacitacion();

    @Query(value = "CALL SP_BUSCAR_CAPACITACION(:idCapacitacion)", nativeQuery = true)
    Optional<Capacitacion> findCapacitacion(@Param("idCapacitacion") int idCapacitacion);

    @Query(value = "CALL SP_INS_CAPACITACION(:noCapacitacion, :deCapacitacion, :feInicioCapacitacion, :feFinCapacitacion, :tiCapacitacion, :idCategoria, :urlImage)", nativeQuery = true)
    Capacitacion saveCapacitacion(
            @Param("noCapacitacion") String noCapacitacion,     @Param("deCapacitacion") String deCapacitacion, @Param("feInicioCapacitacion") Date feInicioCapacitacion,
            @Param("feFinCapacitacion") Date feFinCapacitacion, @Param("tiCapacitacion") String tiCapacitacion, @Param("idCategoria") int idCategoria,
            @Param("urlImage") String urlImage
    );

    @Query(value = "CALL SP_UPD_CAPACITACION(:idCapacitacion, :noCapacitacion, :deCapacitacion, :feInicioCapacitacion, :feFinCapacitacion, :idCategoria, :urlImage)", nativeQuery = true)
    Capacitacion updateCapacitacion(
            @Param("idCapacitacion") int idCapacitacion,           @Param("noCapacitacion") String noCapacitacion,     @Param("deCapacitacion") String deCapacitacion, @Param("feInicioCapacitacion") Date feInicioCapacitacion,
            @Param("feFinCapacitacion") Date feFinCapacitacion,    @Param("idCategoria") int idCategoria,          @Param("urlImage") String urlImage
    );

    @Query(value = "CALL SP_DEL_CAPACITACION(:idCapacitacion)", nativeQuery = true)
    Capacitacion deleteCapacitacion(@Param("idCapacitacion") int idCapacitacion);

}
