package com.cine.msvc_peliculas.service;

import com.cine.msvc_peliculas.model.Pelicula;
import com.cine.msvc_peliculas.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository repository;

    // Listar todas las películas
    public List<Pelicula> listarTodas() {
        return repository.findAll();
    }

    // Buscar una película por su ID
    public Optional<Pelicula> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // Guardar una nueva película o actualizarla
    public Pelicula guardar(Pelicula pelicula) {
        return repository.save(pelicula);
    }

    // Eliminar una película
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

}
