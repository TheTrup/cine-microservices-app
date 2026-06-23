package com.cine.msvc_comentarios.service;

import com.cine.msvc_comentarios.model.Comentario;
import com.cine.msvc_comentarios.repository.ComentarioRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service

public class ComentarioService {

     private final ComentarioRepository repository;

    public ComentarioService(ComentarioRepository repository) {
        this.repository = repository;
    }

    public List<Comentario> listarPorPelicula(Long peliculaId) {
        return repository.findByPeliculaId(peliculaId);
    }

    public Comentario guardar(Comentario comentario) {
        comentario.setFechaCreacion(LocalDateTime.now());
        return repository.save(comentario);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

}
