package com.adra.educate.repository;

import com.adra.educate.entity.Capacitacion;
import com.adra.educate.entity.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface SesionRepository extends JpaRepository<Sesion, Integer> {

}
