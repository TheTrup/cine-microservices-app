package com.cine.msvc_historial.service;


import com.cine.msvc_historial.model.Historial;
import com.cine.msvc_historial.repository.HistorialRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service

public class HistorialService {

    private final HistorialRepository repository;

    public HistorialService(HistorialRepository repository) {
        this.repository = repository;
    }

    public List<Historial> listarPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public Historial registrarEnHistorial(Historial historial) {
        historial.setFechaFinalizacion(LocalDateTime.now());
        return repository.save(historial);
    }

}
