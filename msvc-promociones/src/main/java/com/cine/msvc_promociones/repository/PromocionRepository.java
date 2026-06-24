package com.cine.msvc_promociones.repository;

import com.cine.msvc_promociones.model.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository

public interface PromocionRepository extends JpaRepository<Promocion, Long>{

    // Para buscar el cupón directamente por su texto de código
    Optional<Promocion> findByCodigo(String codigo);

}
