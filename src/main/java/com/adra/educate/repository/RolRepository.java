package com.adra.educate.repository;

import com.adra.educate.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {

    Rol findByNoRol(String noRol);

}
