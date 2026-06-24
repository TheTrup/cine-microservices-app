package com.cine.msvc_salas.service;

import com.cine.msvc_salas.clients.PeliculaClient;
import com.cine.msvc_salas.dto.PeliculaDTO;
import com.cine.msvc_salas.dto.SalaDetallesDTO;
import com.cine.msvc_salas.model.Sala;
import com.cine.msvc_salas.repository.SalaRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    private final SalaRepository repository; 
    private final PeliculaClient peliculaClient;

    // Inyección de dependencias por constructor
    public SalaService(SalaRepository repository, PeliculaClient peliculaClient) {
        this.repository = repository;
        this.peliculaClient = peliculaClient;
    }


    @CircuitBreaker(name = "peliculasCB", fallbackMethod = "fallbackObtenerDetallesDeSala")
    public SalaDetallesDTO obtenerDetallesDeSala(Long idSala) {
        Sala sala = repository.findById(idSala)
                .orElseThrow(() -> new RuntimeException("Sala no encontrada"));

        PeliculaDTO pelicula = peliculaClient.obtenerPeliculaPorId(sala.getPeliculaId());

        SalaDetallesDTO respuesta = new SalaDetallesDTO();
        respuesta.setId(sala.getId());
        respuesta.setNombre(sala.getNombre());
        respuesta.setPelicula(pelicula);
        return respuesta;
    }

    public SalaDetallesDTO fallbackObtenerDetallesDeSala(Long idSala, Throwable t) {
        
        // Seguimos buscando la sala para no dejar al usuario sin nada
        Sala sala = repository.findById(idSala)
                .orElseThrow(() -> new RuntimeException("Sala no encontrada"));

        // Creamos una película "falsa" para avisar del error
        PeliculaDTO peliculaFalsa = new PeliculaDTO();
        peliculaFalsa.setTitulo("Película temporalmente no disponible");
        peliculaFalsa.setSinopsis("El servicio de cartelera está en mantenimiento. Intente más tarde.");

        SalaDetallesDTO respuesta = new SalaDetallesDTO();
        respuesta.setId(sala.getId());
        respuesta.setNombre(sala.getNombre());
        respuesta.setPelicula(peliculaFalsa);
        return respuesta;
    }


    public List<Sala> listarTodas() {
        return repository.findAll();
    }

    public Optional<Sala> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Sala guardar(Sala sala) {
        return repository.save(sala);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

}
