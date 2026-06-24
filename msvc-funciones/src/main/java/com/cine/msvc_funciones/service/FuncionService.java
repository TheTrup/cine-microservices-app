package com.cine.msvc_funciones.service;

import com.cine.msvc_funciones.clients.PeliculaClient;
import com.cine.msvc_funciones.clients.SalaClient;
import com.cine.msvc_funciones.dto.FuncionDetallesDTO;
import com.cine.msvc_funciones.dto.PeliculaDTO;
import com.cine.msvc_funciones.dto.SalaDTO;
import com.cine.msvc_funciones.model.Funcion;
import com.cine.msvc_funciones.repository.FuncionRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FuncionService {

    private final FuncionRepository repository;
    private final PeliculaClient peliculaClient;
    private final SalaClient salaClient;

    public FuncionService(FuncionRepository repository, PeliculaClient peliculaClient, SalaClient salaClient) {
        this.repository = repository;
        this.peliculaClient = peliculaClient;
        this.salaClient = salaClient;
    }

    public List<Funcion> listarTodas() {
        return repository.findAll();
    }

    public Funcion guardar(Funcion funcion) {
        return repository.save(funcion);
    }

    public FuncionDetallesDTO obtenerDetallesDeFuncion(Long id) {
        Funcion funcion = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Función no encontrada"));

        PeliculaDTO pelicula = peliculaClient.obtenerPeliculaPorId(funcion.getPeliculaId());
        SalaDTO sala = salaClient.obtenerSalaPorId(funcion.getSalaId());

        FuncionDetallesDTO detalles = new FuncionDetallesDTO();
        detalles.setId(funcion.getId());
        detalles.setFechaHora(funcion.getFechaHora());
        detalles.setPrecioBase(funcion.getPrecioBase());
        detalles.setPelicula(pelicula);
        detalles.setSala(sala);

        return detalles;
    }
    
}
