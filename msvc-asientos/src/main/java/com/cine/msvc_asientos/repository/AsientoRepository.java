package com.cine.msvc_asientos.repository;

import com.cine.msvc_asientos.model.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AsientoRepository extends JpaRepository<Asiento, Long> {

    List<Asiento> findBySalaId(Long salaId);

}
