package com.cine.msvc_sucursales.repository;

import com.cine.msvc_sucursales.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SucursalRepository extends JpaRepository<Sucursal, Long>{

}
