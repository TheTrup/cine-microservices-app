package com.cine.msvc_funciones.repository;

import com.cine.msvc_funciones.model.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FuncionRepository extends JpaRepository<Funcion, Long>{

    

}
