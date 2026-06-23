package com.cine.msvc_comentarios.repository;

import com.cine.msvc_comentarios.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
    // Permite buscar de golpe todos los comentarios de una película específica
    List<Comentario> findByPeliculaId(Long peliculaId);

}
